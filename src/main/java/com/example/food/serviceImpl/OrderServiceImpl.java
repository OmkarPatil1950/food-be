package com.example.food.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.food.DTO.CreateOrderRequest;
import com.example.food.entity.Order;
import com.example.food.entity.OrderItem;
import com.example.food.repo.OrderItemRepository;
import com.example.food.repo.OrderRepository;
import com.example.food.repo.PlanRepository;
import com.example.food.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createOrderWithItems(Order order, List<OrderItem> orderItems) {
		// Create the Order and save it
		
		System.out.println("inside create Order with items");
        Optional<Order> existingOrder = orderRepository.findByUserIdAndDate(order.getUserId(), order.getDate());
        System.out.println(existingOrder.isPresent());
if(!existingOrder.isPresent()) {
	System.out.println("not present");
	Order createdOrder = orderRepository.save(order);

	// Associate the OrderItems with the created Order and save them
	for (OrderItem orderItem : orderItems) {
		orderItem.setOrder(createdOrder);
		orderItemRepository.save(orderItem);
	}
	System.out.println("present");
	return true;
}
return false;
		

		
	}

	
	
	
	@Override
	public List<Order> getOrdersByUserId(String userId) {
		return orderRepository.findByUserId(userId);
	}

	@Override
	 public Order findOrdersByDate(String date) {
	        return  orderRepository.findByDate(date);
	    }

//	@Override
//	 public Order getOrderById(int orderId) {
//	        return orderRepository.findByOrderId(orderId);
//	    }


@Override
	 public boolean  saveOrder(Order order) {
	        Optional<Order> existingOrder = orderRepository.findByUserIdAndDate(order.getUserId(), order.getDate());

	        if (existingOrder.isPresent()) {
	        	System.out.println("presend");
	            return false;
	        }

	        orderRepository.save(order);
			return true;
	    }

@Override
public Order AddOrder(Order order, List<OrderItem> orderItems) {
	// TODO Auto-generated method stub
	Order createdOrder = orderRepository.save(order);

	// Associate the OrderItems with the created Order and save them
	for (OrderItem orderItem : orderItems) {
		orderItem.setOrder(createdOrder);
		orderItemRepository.save(orderItem);
	}
	
	return createdOrder;
	
}
}


