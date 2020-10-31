package com.wang.simple.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/27 6:33 下午
 */
public class Producer {
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
//       创建连接
        Connection connection = factory.newConnection();
//        创建信道
        Channel channel = connection.createChannel();
//        创建一个队列
//        channel.queueDeclare("hello_world", true, false, false, new HashMap<>());
//        channel.basicPublish("", "hello_world", null, "haha...........".getBytes());

//        /**
//         * String exchange, :交换机名称
//         * BuiltinExchangeType type, 交换机类型
//         * boolean durable, ：是否持久化
//         * boolean autoDelete, 是否自动删除
//         * boolean internal, 是否
//         * Map<String, Object> arguments 参数
//         */


        channel.exchangeDeclare("topic_test", BuiltinExchangeType.TOPIC, true, false, false, null);
//        声明两个队列
        String queue1 = "queue1";
        channel.queueDeclare(queue1, true, false, false, null);
        String queue2 = "queue2";
        channel.queueDeclare(queue2, true, false, false, null);
//        绑定队列
        String routingKey1 = "#.love";
        String routingKey2 = "*.love";

        /**
         * String queue, String exchange, String routingKey, Map<String
         */
        channel.queueBind(queue1, "topic_test", routingKey1, null);
        channel.queueBind(queue2, "topic_test", routingKey2, null);

        /**
         * String exchange,
         * String routingKey,
         * BasicProperties props,
         * byte[] body
         */
        channel.basicPublish("topic_test", "wangfeng.a.love", null, "hello。。。rabbotmq".getBytes());
    }
}
