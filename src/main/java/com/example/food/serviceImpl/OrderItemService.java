package com.example.food.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food.entity.Order;
import com.example.food.entity.OrderItem;
import com.example.food.repo.OrderItemRepository;
import com.example.food.repo.OrderRepository;
import com.example.food.service.OrderService;

@Service
public class OrderItemService implements com.example.food.service.OrderItemService{
	
	@Autowired
    private  OrderItemRepository orderItemRepository;

	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return orderItemRepository.save(orderItem);
	}

	

    
}

