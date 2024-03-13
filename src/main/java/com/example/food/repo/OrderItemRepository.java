package com.example.food.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    // You can add custom queries or methods here if needed
}

