package com.example.food.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food.entity.Plan;
import com.example.food.repo.PlanRepository;
import com.example.food.service.PlanService;

import java.util.Collections;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanRepository planRepository;

    @Override
    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public Plan updatePlan(Plan plan) {
        return planRepository.save(plan);
    }

    @Override
    public void deletePlan(int planId) {
        planRepository.deleteById(planId);
    }
    
   @Override
    public List<Plan> getPlanById(int planId) {
        Plan plan = planRepository.findById(planId).orElse(null);

        if (plan != null) {
            return Collections.singletonList(plan);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }
}
