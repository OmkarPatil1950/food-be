package com.example.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.food.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
    boolean existsByEmail(String email);

}
