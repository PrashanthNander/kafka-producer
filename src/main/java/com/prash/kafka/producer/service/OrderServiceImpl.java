package com.prash.kafka.producer.service;

import com.prash.kafka.producer.model.Order;
import com.prash.kafka.producer.publisher.OrderKafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderKafkaPublisher orderKafkaPublisher;
    @Override
    public Order createOrder(Order order) {

        //We can write a logic to save the order details in database
        orderKafkaPublisher.notifyKafkaConsumer(order);
        return order;
    }
}
