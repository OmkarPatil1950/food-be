package com.example.food.service;

import java.util.List;
import java.util.Optional;

import com.example.food.DTO.CreateOrderRequest;
import com.example.food.entity.Order;
import com.example.food.entity.OrderItem;

public interface OrderService {
    Order createOrder(Order order);
    // Add other service methods as needed

	boolean createOrderWithItems(Order order, List<OrderItem> orderItems);

	List<Order> getOrdersByUserId(String userId);

	Order findOrdersByDate(String date);
	boolean saveOrder(Order order);
	
	Order AddOrder(Order order, List<OrderItem> orderItems);



//	Order getOrderById(int orderId);
}

