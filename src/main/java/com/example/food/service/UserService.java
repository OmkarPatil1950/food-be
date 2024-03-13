package com.example.food.service;

import java.util.List;
import java.util.Optional;

import com.example.food.entity.User;

public interface UserService {
    User createUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
	User getUserById(int userId);
	void deleteUser(int userId);
	User getUserByEmail(String email);
	User updatePoints(User user);
	boolean doesUserExistByEmail(String email);
}
