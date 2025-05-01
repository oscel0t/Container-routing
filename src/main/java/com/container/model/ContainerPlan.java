package com.container.model;

import java.util.List;

public class ContainerPlan {
    public int container_id;
    public List<String> path;
    public int cost;

    public ContainerPlan(int id, List<String> path, int cost) {
        this.container_id = id;
        this.path = path;
        this.cost = cost;
    }
}
