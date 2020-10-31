//package com.wang.test;
//
//import com.wang.producer.ProducerApp;
//import com.wang.producer.config.RabbitConfig;
//import org.junit.runner.RunWith;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author 一只永不言弃的小乌龟
// * @create 2020/10/30 2:42 下午
// *
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProducerApp.class)
//public class confirmTest {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    public void test() {
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "a.hello", "a....b....c");
//    }
//}
