package com.wang.simple.consumer;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/27 6:33 下午
 */
public class Consumer_Topic_2 {
    public static void main(String[] args) throws IOException, TimeoutException {
//        创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //        用户名
        factory.setUsername("guest");
//        密码
        factory.setPassword("guest");
//        虚拟机
        factory.setVirtualHost("/");
//        IP地址
        factory.setHost("localhost");
//        端口号
        factory.setPort(5672);
//        创建连接
        Connection connection = factory.newConnection();
//        创建信道
        Channel channel = connection.createChannel();
//创建队列
        String queue1 = "queue1";
        String queue2 = "queue2";

//        创建队列
        channel.queueDeclare(queue2, true, false, false, new HashMap<>());
//      获取消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
            }
        };
        String s = channel.basicConsume(queue2, consumer);
        System.out.println("s" + s);
    }
}
