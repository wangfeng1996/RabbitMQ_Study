package com.wang.test;

import com.wang.producer.ProducerApp;
import com.wang.producer.config.RabbitConfigDlx;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/30 12:27 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApp.class)
public class DlxTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test() {

        MessagePostProcessor messagePostProcessor = new MessagePostProcessor() {
            /**
             *
             * @param message 消息的过期时间怎么设置
             * @return
             * @throws AmqpException
             */

            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                // 毫秒值
                message.getMessageProperties().setExpiration("10000");
                return message;
            }
        };
//        消息过期时间
//        rabbitTemplate.convertAndSend(RabbitConfigDlx.EXCHANGE_NAME_NORMAL, "normal.hello", "hao are you", messagePostProcessor);

//        长度
//        for (int i = 1; i < 10; i++) {
//            rabbitTemplate.convertAndSend(RabbitConfigDlx.EXCHANGE_NAME_NORMAL, "normal.hello", "hao are you");
//        }
//  延迟队列
        rabbitTemplate.convertAndSend(RabbitConfigDlx.EXCHANGE_NAME_NORMAL, "normal.hello", "hao are you");


    }
}
