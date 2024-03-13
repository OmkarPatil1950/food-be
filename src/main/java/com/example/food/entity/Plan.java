package com.example.food.entity;



import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "plans")
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int plan_id;

    private String plan_name;

    private String description;

    private double price;

    private int points;

    private int no_of_days;

    private int total_points;
    
    private String image_url;

	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public Plan(int plan_id, String plan_name, String description, double price, int points, int no_of_days,
			int total_points, String image_url) {
		super();
		this.plan_id = plan_id;
		this.plan_name = plan_name;
		this.description = description;
		this.price = price;
		this.points = points;
		this.no_of_days = no_of_days;
		this.total_points = total_points;
		this.image_url = image_url;
	}



	public int getPlan_id() {
		return plan_id;
	}



	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}



	public String getPlan_name() {
		return plan_name;
	}



	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
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



	public int getNo_of_days() {
		return no_of_days;
	}



	public void setNo_of_days(int no_of_days) {
		this.no_of_days = no_of_days;
	}



	public int getTotal_points() {
		return total_points;
	}



	public void setTotal_points(int total_points) {
		this.total_points = total_points;
	}



	public String getImage_url() {
		return image_url;
	}



	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}



	@PrePersist
    @PreUpdate
    private void calculateTotalPoints() {
        this.total_points = this.points * this.no_of_days;
    }
}

