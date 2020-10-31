package com.wang.consumer.listener;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import org.springframework.stereotype.Component;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/30 11:19 上午
 */
@Component
public class ConsumerListenerDlx_02 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println(s);

    }
}
