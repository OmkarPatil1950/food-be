package com.example.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
