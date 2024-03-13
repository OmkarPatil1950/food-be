package com.example.food.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.food.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // You can add custom queries or methods here if needed
    List<Order> findByUserId(String userId);

    @Query(value = "SELECT " +
            "o.order_id, " +
            "o.date, " +
            "o.user_id, " +
            "o.user_type, " +
            "oi.order_item_id, " +
            "oi.dish_name, " +
            "oi.order_status, " +
            "oi.payment_type, " +
            "oi.points_deducted, " +
            "oi.price, " +
            "oi.quantity, " +
            "oi.user_name_or_guest_name " +
        "FROM " +
            "orders o " +
        "INNER JOIN " +
            "order_item oi " +
        "ON " +
            "o.order_id = oi.order_order_id " +
        "WHERE " +
            "o.date = :date", nativeQuery = true)
Order findByDate(@Param("date") String date);

    

        Optional<Order> findByUserIdAndDate(String userId, String date);
    
    
    
    
}
