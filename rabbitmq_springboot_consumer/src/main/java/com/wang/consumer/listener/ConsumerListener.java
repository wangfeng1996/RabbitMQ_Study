//package com.wang.consumer.listener;
//
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessageListener;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @author 一只永不言弃的小乌龟
// * @create 2020/10/30 11:19 上午
// */
//@Component
//public class ConsumerListener implements MessageListener {
//    @Override
//    /**
//     * queue_fanout
//     * queue_topic
//     */
//    @RabbitListener(queues = "second_queue")
//    public void onMessage(Message message) {
//        System.out.println(new String(message.getBody()));
//    }
//}
