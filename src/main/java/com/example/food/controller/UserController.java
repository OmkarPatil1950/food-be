package com.example.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.food.entity.User;
import com.example.food.repo.UserRepository;
import com.example.food.service.UserService;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin("http://localhost:3000")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;

	@PostMapping("/createUser")
	public ResponseEntity<String> createUser(@RequestBody User user) {
		System.out.println("inside post mapping and the user is " + user);
		String email = user.getEmail();
		System.out.println(email);
		// Check if the email already exists in the database
		boolean existingUser = userService.doesUserExistByEmail(email);

		if (existingUser) {
			// Email already exists in the database
			System.out.println("already exists");
			return new ResponseEntity<>("User already exists", HttpStatus.ALREADY_REPORTED);
		} else {
			// Email doesn't exist, create the user
			User createdUser = userService.createUser(user);
			System.out.println("Inside the post User");
			return new ResponseEntity<>("User created", HttpStatus.CREATED);
		}
	}

	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user) {
		System.out.println("updating"+user);
		user.setUser_id(userId);
		User updatedUser = userService.updateUser(user);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable int userId) {
		User user = userService.getUserById(userId);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody User loginUser) {
		// Check if the email exists in the database
		System.out.println("Checking whether email is present in db or not");
		System.out.println(loginUser.getEmail());
		User existingUser = userService.getUserByEmail(loginUser.getEmail());
		if (existingUser != null) {
			System.out.println(existingUser);
			// Email exists, check if the password matches
			if (existingUser.getPassword().equals(loginUser.getPassword())) {
				// Password matches, return login success
				return new ResponseEntity<>("Login successful", HttpStatus.OK);
			} else {
				// Password does not match
				return new ResponseEntity<>("Password incorrect", HttpStatus.UNAUTHORIZED);
			}
		} else {
			// Email not found
			return new ResponseEntity<>("Email not found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getUserByEmail")
	public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
		// Check if the email exists in the database
		System.out.println(email);
		User user = userService.getUserByEmail(email);

		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/updatePlanId/{userId}")
	public ResponseEntity<User> updatePlanId(@PathVariable int userId, @RequestParam int newPlanId,
			@RequestParam String selectedDate, @RequestParam String endDate, @RequestParam int points,
			@RequestParam int total_points) {
		User user = userService.getUserById(userId);
		if (user == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		// Update the plan_id for the user
		user.setPlan_Id(newPlanId); // Assuming you have a setter method for plan_id in the User class
		user.setPlan_Startdate(selectedDate);
		user.setPlan_endDate(endDate);
		user.setPoints(points);
		user.setTotal_points(total_points);
		User updatedUser = userService.updateUser(user);

		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // You can change this response code
																			// accordingly
		}
	}

	@PutMapping("/{userId}/decreaseTotalPoints")
	public ResponseEntity<String> decreaseTotalPoints(@PathVariable int userId, @RequestParam int pointsToDecrease) {
		System.out.println("inside points to decrease");
		System.out.println(userId);
		System.out.println(pointsToDecrease);

		User user = userRepository.findById(userId).orElse(null);

		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
		}

		int currentPoints = user.getPoints();
		System.out.println(currentPoints + "current points -------");
		int totalPoints = user.getTotal_points();
		System.out.println(totalPoints + "total points -------");
		if (pointsToDecrease > currentPoints) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insufficient points");
		} else {
			int newPoints = totalPoints - pointsToDecrease;
			int newTotalPoints = newPoints;
			System.out.println(newPoints + "new points -------");
			System.out.println(newTotalPoints + "new total points -------");

			user.setTotal_points(newPoints);
			System.out.println("---------------user");
			System.out.println(user);
			userService.updatePoints(user);

			return ResponseEntity.ok("Total points decreased successfully");
		}
	}
}
