package com.example.food.entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    private String name;

    private String contact_num;

    private String email;

    private String gender;

   

	private String address;

    private String password;

    private int plan_Id;

    private int points;
    
    private int total_points;

    @Temporal(TemporalType.DATE)
    private String plan_Startdate;

    @Temporal(TemporalType.DATE)
    private String plan_endDate;

	
	 public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int user_id, String name, String contact_num, String email, String gender, String address,
			String password, int plan_Id, int points, int total_points, String plan_Startdate, String plan_endDate) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.contact_num = contact_num;
		this.email = email;
		this.gender = gender;
		this.address = address;
		this.password = password;
		this.plan_Id = plan_Id;
		this.points = points;
		this.total_points = total_points;
		this.plan_Startdate = plan_Startdate;
		this.plan_endDate = plan_endDate;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getContact_num() {
		return contact_num;
	}


	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPlan_Id() {
		return plan_Id;
	}


	public void setPlan_Id(int plan_Id) {
		this.plan_Id = plan_Id;
	}


	public int getPoints() {
		return points;
	}


	public void setPoints(int points) {
		this.points = points;
	}


	public int getTotal_points() {
		return total_points;
	}


	public void setTotal_points(int total_points) {
		this.total_points = total_points;
	}


	public String getPlan_Startdate() {
		return plan_Startdate;
	}


	public void setPlan_Startdate(String plan_Startdate) {
		this.plan_Startdate = plan_Startdate;
	}


	public String getPlan_endDate() {
		return plan_endDate;
	}


	public void setPlan_endDate(String plan_endDate) {
		this.plan_endDate = plan_endDate;
	}

//	@PrePersist
//    @PreUpdate
//    private void calculateTotalPoints() {
//        this.total_points = this.points * 30;
//    }


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", contact_num=" + contact_num + ", email=" + email
				+ ", gender=" + gender + ", address=" + address + ", password=" + password + ", plan_Id=" + plan_Id
				+ ", points=" + points + ", total_points=" + total_points + ", plan_Startdate=" + plan_Startdate
				+ ", plan_endDate=" + plan_endDate + "]";
	}
	
	
    // Constructors, getters, and setters
    
    
}
