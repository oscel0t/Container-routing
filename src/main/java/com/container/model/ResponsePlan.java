package com.container.model;

import java.util.List;

public class ResponsePlan {
    public List<ContainerPlan> plan;
    public int total_cost;

    public ResponsePlan(List<ContainerPlan> plan, int total_cost) {
        this.plan = plan;
        this.total_cost = total_cost;
    }
}
