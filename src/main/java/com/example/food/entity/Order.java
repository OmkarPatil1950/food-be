package com.example.food.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId; // Auto-incremented primary key

	private String userId; // User's unique identifier
	private String userType; // Type of user (registered, guest, etc.)

	@Column
	private String date;

	@JsonManagedReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
	private List<OrderItem> orderItems;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, String userId, String userType, String date, List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.userType = userType;
		this.date = date;
		this.orderItems = orderItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", userType=" + userType + ", date=" + date
				+ ", orderItems=" + orderItems + "]";
	}

	// Constructors, getters, setters, and other methods
	// ...

}
