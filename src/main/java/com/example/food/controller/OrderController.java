package com.example.food.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.food.DTO.CreateOrderRequest;
import com.example.food.entity.Order;
import com.example.food.repo.OrderRepository;
import com.example.food.service.OrderService;



@RestController
@RequestMapping("/orders")
@CrossOrigin("http://localhost:3000")
public class OrderController {
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private OrderRepository orderRepository;

    
    @PostMapping("/create-with-items")
    public ResponseEntity<String> createOrderWithItems(@RequestBody CreateOrderRequest createOrderRequest) {
        System.out.println(createOrderRequest+"1");
//        try {
//            boolean createdOrder = orderService.createOrderWithItems(createOrderRequest.getOrder(), createOrderRequest.getOrderItems());
//            return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
//        } catch (Exception e) {
//        	System.out.println(HttpStatus.ALREADY_REPORTED);
//            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//        }
        if(orderService.createOrderWithItems(createOrderRequest.getOrder(), createOrderRequest.getOrderItems())) {
        	System.out.println("1");
            return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);

        }
        else {
        	System.out.println(HttpStatus.ALREADY_REPORTED);
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
    }

    @PostMapping("/AddOrder")
    public ResponseEntity<String> AddOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        System.out.println(createOrderRequest+"1");
//        try {
//            boolean createdOrder = orderService.createOrderWithItems(createOrderRequest.getOrder(), createOrderRequest.getOrderItems());
//            return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
//        } catch (Exception e) {
//        	System.out.println(HttpStatus.ALREADY_REPORTED);
//            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//        }
        Order o= orderService.AddOrder(createOrderRequest.getOrder(), createOrderRequest.getOrderItems());
        	System.out.println(o);
            return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);

        
    }

//    @PostMapping("/create-with-items")
//    public ResponseEntity<String> createOrder(@RequestBody Order order) {
//    	  if (orderService.saveOrder(order)) {
//              return new ResponseEntity<>("Order created successfully", HttpStatus.CREATED);
//          } else {
//              return new ResponseEntity<>("Order already exists for user " + order.getUserId() + " on date " + order.getDate(), HttpStatus.CONFLICT);
//          }
//    }    
    @GetMapping("/orders")
    public List<Order> getOrdersByUserId(@RequestParam String userId) {
        return orderService.getOrdersByUserId(userId);
    }
    
    @GetMapping("/by-date")
    public ResponseEntity<Order> findOrdersByDate(@RequestParam("date") String date) {
        Order orders = orderService.findOrdersByDate(date);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
    
   
   

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable int orderId) {
    	System.out.println("inside order by order_id");
    	 Optional<Order> order = orderRepository.findById(orderId);
		return ResponseEntity.ok(order);
    	
    }
}
	