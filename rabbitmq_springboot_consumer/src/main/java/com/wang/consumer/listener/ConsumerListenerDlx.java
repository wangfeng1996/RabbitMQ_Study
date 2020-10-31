package com.wang.consumer.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/30 11:19 上午
 */
@Component
public class ConsumerListenerDlx implements ChannelAwareMessageListener {
    /**
     * @param message 消息
     * @param channel 签收
     * @throws Exception
     */

    @RabbitListener(queues = "normal_queue_name")
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        byte[] body = message.getBody();
        String s = new String(body);
        System.out.println("message:" + s);
        try {
            int i = 3 / 0;
//            手动签收
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);

        } catch (Exception e) {
//拒绝收订签收，并且不会队列中
            channel.basicNack(message.getMessageProperties().getDeliveryTag(), true, false);

        }

    }
}
