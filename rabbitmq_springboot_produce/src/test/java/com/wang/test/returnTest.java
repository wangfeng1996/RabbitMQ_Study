//package com.wang.test;
//
//import com.wang.producer.ProducerApp;
//import com.wang.producer.config.RabbitConfig;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.amqp.core.Message;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @author 一只永不言弃的小乌龟
// * @create 2020/10/30 2:52 下午
// */
//
//@SpringBootTest(classes = ProducerApp.class)
//@RunWith(SpringRunner.class)
//public class returnTest {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Test
//    public void rerunPattern() {
//        // 设置交换机处理失败的消息的模式(消息处理失败后将消息返给我回调函数，true处理，false 丢弃)
//        rabbitTemplate.setMandatory(true);
////        消息投递失败的情况下回调
//        rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
//            /**
//             *
//             * @param message
//             * @param replyCode
//             * @param replyText
//             * @param exchange
//             * @param routingKey
//             */
//            @Override
//            public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
////                处理方式：1、 写入数据库(定时任务扫描失败的消息，并且消息将重新发送)    2、直接重新发送(一般不用，不提倡)
//
//            }
//        });
//
//
//        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, "a.b.love", "......how are you");
//    }
//
//
//}
