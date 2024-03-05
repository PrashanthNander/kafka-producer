package com.prash.kafka.producer.service;

import com.prash.kafka.producer.model.Order;

public interface OrderService {

    public Order createOrder(Order order);
}
