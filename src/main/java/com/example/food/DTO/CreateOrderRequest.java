package com.example.food.DTO;

import java.util.List;

import com.example.food.entity.Order;
import com.example.food.entity.OrderItem;

public class CreateOrderRequest {
    private Order order;
    private List<OrderItem> orderItems;
	public CreateOrderRequest(Order order, List<OrderItem> orderItems) {
		super();
		this.order = order;
		this.orderItems = orderItems;
	}
	public CreateOrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "CreateOrderRequest [order=" + order + ", orderItems=" + orderItems + "]";
	}

    // Getters and setters
}

