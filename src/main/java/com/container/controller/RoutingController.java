package com.container.controller;

import com.container.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class RoutingController {

    @PostMapping("/optimize")
    public ResponsePlan optimize(@RequestBody RequestData data) {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        for (Route r : data.routes) {
            graph.putIfAbsent(r.from, new HashMap<>());
            graph.get(r.from).put(r.to, r.cost);
        }

        List<ContainerPlan> resultPlans = new ArrayList<>();
        int totalCost = 0;

        for (Container c : data.containers) {
            List<String> path = new ArrayList<>();
            int cost = dijkstra(graph, c.source, c.destination, path);
            ContainerPlan plan = new ContainerPlan(c.id, path, cost);
            resultPlans.add(plan);
            totalCost += cost;
        }

        return new ResponsePlan(resultPlans, totalCost);
    }

    private int dijkstra(Map<String, Map<String, Integer>> graph, String start, String end, List<String> path) {
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        for (String node : graph.keySet()) dist.put(node, Integer.MAX_VALUE);
        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String u = pq.poll();
            if (u.equals(end)) break;

            for (Map.Entry<String, Integer> neighbor : graph.getOrDefault(u, Map.of()).entrySet()) {
                int alt = dist.get(u) + neighbor.getValue();
                if (alt < dist.getOrDefault(neighbor.getKey(), Integer.MAX_VALUE)) {
                    dist.put(neighbor.getKey(), alt);
                    prev.put(neighbor.getKey(), u);
                    pq.add(neighbor.getKey());
                }
            }
        }

        String curr = end;
        while (curr != null) {
            path.add(0, curr);
            curr = prev.get(curr);
        }

        return dist.getOrDefault(end, 0);
    }
}
