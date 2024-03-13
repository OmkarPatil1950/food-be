package com.example.food.service;

import java.util.List;

import com.example.food.entity.Dish;

public interface DishService {
    Dish createDish(Dish dish);
    Dish updateDish(Dish dish);
    void deleteDish(Dish dishId);
    List<Dish> getAllDishes();
	Dish getDishById(int dishId);
	List<Dish> getAllDishesByType(String type);
}
