package com.example.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.food.entity.Dish;
import com.example.food.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/dishes")
@CrossOrigin("http://localhost:3000")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    public Dish createDish(@RequestBody Dish dish) {
        return dishService.createDish(dish);
    }

    @PutMapping("/{dishId}")
    public Dish updateDish(@PathVariable int dishId, @RequestBody Dish dish) {
        dish.setDishId(dishId);
        return dishService.updateDish(dish);
    }

    @DeleteMapping("/{dishId}")
    public void deleteDish(@PathVariable Dish dishId) {
        dishService.deleteDish(dishId);
    }

    @GetMapping("/{dishId}")
    public Dish getDishById(@PathVariable int dishId) {
        return dishService.getDishById(dishId);
    }

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }
    
    @GetMapping("/byType")
    public ResponseEntity<List<Dish>> getAllDishesByTpe(@RequestParam("type") String type) {
        List<Dish> dishes = dishService.getAllDishesByType(type);
        if (dishes.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(dishes, HttpStatus.OK);
        }
    }
}
