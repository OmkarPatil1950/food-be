package com.example.food.service;

import java.util.List;

import com.example.food.entity.Plan;

public interface PlanService {
    Plan createPlan(Plan plan);
    Plan updatePlan(Plan plan);
    void deletePlan(int planId);
    List<Plan> getPlanById(int planId);
    List<Plan> getAllPlans();
}

