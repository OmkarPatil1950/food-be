package com.example.food.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.food.entity.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

	List<Dish> findByType(String type);
}