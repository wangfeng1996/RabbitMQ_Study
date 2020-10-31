package com.wang.listener;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/29 2:32 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-simple.xml"})
public class SimpleListenerTest {

    @Test
    public void simpleTest() {

        while (true) {

        }
    }

}
