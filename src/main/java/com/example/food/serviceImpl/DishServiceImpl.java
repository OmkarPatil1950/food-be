package com.example.food.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food.entity.Dish;
import com.example.food.repo.DishRepository;
import com.example.food.service.DishService;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public Dish createDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Dish updateDish(Dish dish) {
        // To update a Dish, you can use the save method again. 
        // Spring Data JPA will automatically update the record if it exists.
        return dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Dish dish) {
        dishRepository.delete(dish);
    }

    

    @Override
    public List<Dish> getAllDishes() {
        return dishRepository.findAll();
    }

	@Override
	public Dish getDishById(int dishId) {
		// TODO Auto-generated method stub
        return dishRepository.findById(dishId).orElse(null);
	}

	
	 @Override
	    public List<Dish> getAllDishesByType(String type) {
	        return dishRepository.findByType(type);
	    }
}
