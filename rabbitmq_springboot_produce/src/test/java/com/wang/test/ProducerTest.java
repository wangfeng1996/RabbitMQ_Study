//package com.wang.test;
//
//import com.wang.producer.ProducerApp;
//import com.wang.producer.config.RabbitConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import org.springframework.amqp.AmqpException;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.core.MessagePostProcessor;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author 一只永不言弃的小乌龟
// * @create 2020/10/30 12:27 下午
// */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = ProducerApp.class)
//public class ProducerTest {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Test
//    public void test() {
////        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
////            /**
////             *
////             * @param message 消息的过期时间怎么设置
////             * @return
////             * @throws AmqpException
////             */
////
////            @Override
////            public Message postProcessMessage(Message message) throws AmqpException {
////                // 毫秒值
////                message.getMessageProperties().setExpiration("50000");
////                return null;
////            }
////        };
////
////        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "b.love", "......how are you", messagePostProcessor);
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "c.hello", "a.c.c.c.c.ds.a.");
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "b.hello", "a.c.c.c.c.ds.a.");
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "a.hello", "a.c.c.c.c.ds.a.");
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "d.hello", "a.c.c.c.c.ds.a.");
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "e.hello", "a.c.c.c.c.ds.a.");
//
//    }
//
//}
