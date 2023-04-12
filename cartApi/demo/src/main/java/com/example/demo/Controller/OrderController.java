package com.example.demo.Controller;


import com.example.demo.Services.OrderService;
import com.example.demo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.createOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Void> updateOrder(@PathVariable String id, @RequestBody Order order) {
//        Order existingOrder = orderService.getOrderById(id);
//        if (existingOrder == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        existingOrder.setUserName(order.getUserName());
//        existingOrder.setOrderDate(order.getOrderDate());
//        existingOrder.setOrderDetails(order.getOrderDetails());
//        orderService.updateOrder(existingOrder);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
