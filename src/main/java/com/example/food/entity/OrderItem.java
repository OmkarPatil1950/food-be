package com.example.food.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    private String dishName;
    private int quantity;
    private int price;
    private int pointsDeducted;
    private String orderStatus;
    private String paymentType;
    private String userNameOrGuestName;
    private String orderAddress;


    @ManyToOne
    @JsonBackReference
    private Order order;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getQuantity() {
		return quantity;
	}

	public OrderItem(int orderItemId, String dishName, int quantity, int price, int pointsDeducted, String orderStatus,
			String paymentType, String userNameOrGuestName, String orderAddress, Order order) {
		super();
		this.orderItemId = orderItemId;
		this.dishName = dishName;
		this.quantity = quantity;			
		this.price = price;
		this.pointsDeducted = pointsDeducted;
		this.orderStatus = orderStatus;
		this.paymentType = paymentType;
		this.userNameOrGuestName = userNameOrGuestName;
		this.orderAddress = orderAddress;
		this.order = order;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPointsDeducted() {
		return pointsDeducted;
	}

	public void setPointsDeducted(int pointsDeducted) {
		this.pointsDeducted = pointsDeducted;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getUserNameOrGuestName() {
		return userNameOrGuestName;
	}

	public void setUserNameOrGuestName(String userNameOrGuestName) {
		this.userNameOrGuestName = userNameOrGuestName;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", dishName=" + dishName + ", quantity=" + quantity
				+ ", price=" + price + ", pointsDeducted=" + pointsDeducted + ", orderStatus=" + orderStatus
				+ ", paymentType=" + paymentType + ", userNameOrGuestName=" + userNameOrGuestName + ", orderAddress="
				+ orderAddress + ", order=" + order + "]";
	}

	

    // Constructors, getters, setters, and other methods
    // ...
}
