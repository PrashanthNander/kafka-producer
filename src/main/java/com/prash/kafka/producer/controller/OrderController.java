package com.prash.kafka.producer.controller;


import com.prash.kafka.producer.model.Order;
import com.prash.kafka.producer.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @GetMapping("/ping")
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        log.info("Request received to place an order.");
        order = orderService.createOrder(order);
        log.info("Request to place an order completed.");
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
