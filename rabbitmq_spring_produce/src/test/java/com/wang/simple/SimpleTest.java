package com.wang.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/28 6:23 下午
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-simple.xml"})
public class SimpleTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testForSimple() {
        rabbitTemplate.convertAndSend("","helloWorld","hello_hahahahhah.....");
    }


}
