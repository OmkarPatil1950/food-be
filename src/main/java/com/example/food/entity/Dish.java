package com.example.food.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dishId;
    private String dishName;
    private String description;
    private double price;
    private int points;
    private String type;
    private String imageUrl;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

		

	public Dish(int dishId, String dishName, String description, double price, int points, String type,
			String imageUrl) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.description = description;
		this.price = price;
		this.points = points;
		this.type = type;
		this.imageUrl = imageUrl;
	}

	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
   
}

