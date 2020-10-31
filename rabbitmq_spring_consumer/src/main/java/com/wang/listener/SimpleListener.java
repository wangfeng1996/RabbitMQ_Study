package com.wang.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/29 2:28 下午
 */
public class SimpleListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        byte[] body = message.getBody();
        System.out.println(new String(body));
    }
}
