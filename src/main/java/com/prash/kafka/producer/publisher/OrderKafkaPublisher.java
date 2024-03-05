package com.prash.kafka.producer.publisher;

import com.prash.kafka.producer.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class OrderKafkaPublisher {

    private static final Logger log = LoggerFactory.getLogger(OrderKafkaPublisher.class);

    @Autowired
    private KafkaTemplate<String, Order> orderKafkaTemplate;

    @Value("${kafka.order.topic.name}")
    private String orderTopic;

    /**
     *  This method sends the Order details to Kafka Order Topic
     * @param order - Order Details
     */
    public void notifyKafkaConsumer(Order order) {
        CompletableFuture<SendResult<String, Order>> future = orderKafkaTemplate.send(orderTopic, order);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent order details [{}] to the topic [{}] with partition [{}] and offset [{}]"
                        , order.toString(), result.getRecordMetadata().topic(), result.getRecordMetadata().partition(),result.getRecordMetadata().offset());
            } else {
                log.error("Unable to send order details [{}] due to [{}]", order.toString(), ex.getMessage());
            }
        });
    }
}
