package com.example.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.food.entity.Plan;
import com.example.food.service.PlanService;

import java.util.List;

@RestController
@RequestMapping("/plans")
@CrossOrigin("http://localhost:3000")
public class PlanController {
    @Autowired
    private PlanService planService;

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

    @PutMapping("/{planId}")
    public Plan updatePlan(@PathVariable int planId, @RequestBody Plan plan) {
        plan.setPlan_id(planId);
        return planService.updatePlan(plan);
    }

    @DeleteMapping("/{planId}")
    public void deletePlan(@PathVariable int planId) {
        planService.deletePlan(planId);
    }

    @GetMapping("/{planId}")
    public List<Plan> getPlanById(@PathVariable int planId) {
        return planService.getPlanById(planId);
    }

    @GetMapping
    public List<Plan> getAllPlans() {
        return planService.getAllPlans();
    }
}

