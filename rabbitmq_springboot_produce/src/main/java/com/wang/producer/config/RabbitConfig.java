//package com.wang.producer.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author 一只永不言弃的小乌龟
// * @create 2020/10/30 10:02 上午
// */
//@Configuration
//public class RabbitConfig {
//    public static final String EXCHANGE_NAME = "exchange";
//    public static final String EXCHANGE_BEAN_NAME = "exchange_bean";
//
//    public static final String FIRST_QUEUE_NAME = "first_queue";
//    public static final String First_QUEUE_BEAN_NAME = "first_queue_bean";
//
//    public static final String SECOND_QUEUE_NAME = "second_queue";
//    public static final String SECOND_QUEUE_BEAN_NAME = "second_queue_bean";
//
//
//    public static final String ROTING_KEY1 = "#.hello";
//    public static final String ROTING_KEY2 = "*.love";
//
//    /**
//     * 声明交换机 exchange
//     *
//     * @return 交换机
//     */
//    @Bean(name = EXCHANGE_BEAN_NAME)
//    public Exchange exchange() {
//        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
//    }
//
//    /**
//     * 声明队列 queue
//     * expires 过期时间（单位是毫秒值）---  申明队列的过期时间
//     *
//     * @return 队列
//     */
//    @Bean(name = First_QUEUE_BEAN_NAME)
//    public Queue firstQueue() {
//        return QueueBuilder.durable(FIRST_QUEUE_NAME).build();
//    }
//
//
//    @Bean(name = SECOND_QUEUE_BEAN_NAME)
//    public Queue secondQueue() {
//        return QueueBuilder.durable(SECOND_QUEUE_NAME).build();
//    }
//
//
//    /**
//     * 队列1绑定交换机
//     *
//     * @param queue    队列
//     * @param exchange 交换机
//     * @return 绑定对象
//     */
//    @Bean
//    public Binding binding1(@Qualifier(value = First_QUEUE_BEAN_NAME) Queue queue, @Qualifier(value = EXCHANGE_BEAN_NAME) Exchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(ROTING_KEY1).noargs();
//    }
//
//    /**
//     * 队列2绑定交换机
//     *
//     * @param queue    队列
//     * @param exchange 交换机
//     * @return 绑定对象
//     */
//
//    @Bean
//    public Binding binding2(@Qualifier(value = SECOND_QUEUE_BEAN_NAME) Queue queue, @Qualifier(value = EXCHANGE_BEAN_NAME) Exchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(ROTING_KEY2).noargs();
//
//    }
//}
