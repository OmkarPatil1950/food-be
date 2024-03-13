package com.example.food.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.food.entity.User;
import com.example.food.repo.UserRepository;
import com.example.food.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User updatedUser) {
        // Check if the user with the provided ID exists in the database
        User existingUser = userRepository.findById(updatedUser.getUser_id()).orElse(null);

        if (existingUser != null) {
            // You can update any fields you need here
        	existingUser.setName(updatedUser.getName());
        	existingUser.setContact_num(updatedUser.getContact_num());
        	existingUser.setEmail(updatedUser.getEmail());
        	existingUser.setGender(updatedUser.getGender());
        	existingUser.setAddress(updatedUser.getAddress());
        	existingUser.setPassword(updatedUser.getPassword());
        	existingUser.setPlan_Id(updatedUser.getPlan_Id());
        	existingUser.setPoints(updatedUser.getPoints());
        	existingUser.setTotal_points(updatedUser.getTotal_points());
        	existingUser.setPlan_Startdate(updatedUser.getPlan_Startdate());
        	existingUser.setPlan_endDate(updatedUser.getPlan_endDate());
            
            // Update other fields as needed
System.out.println(existingUser+"-----------------existing user");
            // Save the updated user to the database
            return userRepository.save(existingUser);
        }

        return null; // Return null if the user doesn't exist
    }
    @Override
    public User updatePoints(User updatedUser) {
        // Check if the user with the provided ID exists in the database
        User existingUser = userRepository.findById(updatedUser.getUser_id()).orElse(null);

        if (existingUser != null) {
            // You can update any fields you need here
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setPlan_Startdate(updatedUser.getPlan_Startdate());
            existingUser.setPlan_endDate(updatedUser.getPlan_Startdate());
            existingUser.setTotal_points(updatedUser.getTotal_points());
            // Update other fields as needed

            // Save the updated user to the database
            return userRepository.save(existingUser);
        }

        return null; // Return null if the user doesn't exist
    }

    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userRepository.deleteById(userId);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}
	
	@Override
	public boolean doesUserExistByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);
	}

	
}
