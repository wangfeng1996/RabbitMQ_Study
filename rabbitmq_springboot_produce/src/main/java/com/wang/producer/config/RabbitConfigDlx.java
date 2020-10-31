package com.wang.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 一只永不言弃的小乌龟
 * @create 2020/10/31 11:17 上午
 */
@Configuration
public class RabbitConfigDlx {
    public static final String EXCHANGE_NAME_NORMAL = "normal_exchange";
    public static final String EXCHANGE_NAME_DLX = "dlx_exchange";

    public static final String EXCHANGE_NAME_NORMAL_Bean = "normal_exchange_bean";
    public static final String EXCHANGE_NAME_DLX_Bean = "dlx_exchange_bean";

    public static final String QUEUE_NAME_NORMAL = "normal_queue_name";
    public static final String QUEUE_NAME_NORMAL_BEAN = "normal_queue_bean";

    public static final String QUEUE_NAME_DLX = "dlx_queue_name";
    public static final String QUEUE_NAME_DLX_BEAN = "dlx_queue_bean";


    /**
     * 声明正常的交换机
     *
     * @return
     */
    @Bean(name = EXCHANGE_NAME_NORMAL_Bean)
    public Exchange normalExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME_NORMAL).durable(true).build();
    }

    /**
     * 声明死信交换机
     *
     * @return
     */
    @Bean(name = EXCHANGE_NAME_DLX_Bean)
    public Exchange dlxExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME_DLX).durable(true).build();
    }


//    /**
//     * 声明正常的队列
//     *
//     * @return
//     */
//    @Bean(name = QUEUE_NAME_NORMAL_BEAN)
//    public Queue normalQueue() {
//        return QueueBuilder.durable(QUEUE_NAME_NORMAL).
//                deadLetterExchange(EXCHANGE_NAME_DLX).
//                deadLetterRoutingKey("dlx.hello").build();
//    }

//    /**
//     * 设置队列的长度  如果队列的长度多余5，将多余的队列设置为死信队列
//     * @return
//     */
//
//    @Bean(name = QUEUE_NAME_NORMAL_BEAN)
//    public Queue normalQueue() {
//        return QueueBuilder.durable(QUEUE_NAME_NORMAL).
//                deadLetterExchange(EXCHANGE_NAME_DLX).
//                deadLetterRoutingKey("dlx.hello").maxLength(5).build();
//    }


    /**
     * 设置队列过期时间（延迟队列）
     *
     * @return
     */
    @Bean(name = QUEUE_NAME_NORMAL_BEAN)
    public Queue normalQueue() {


        return QueueBuilder.durable(QUEUE_NAME_NORMAL).
                deadLetterExchange(EXCHANGE_NAME_DLX).
                deadLetterRoutingKey("dlx.hello").
                withArgument("x-message-ttl", 10000).build();

    }


    /**
     * 声明死信队列
     *
     * @return
     */
    @Bean(name = QUEUE_NAME_DLX_BEAN)
    public Queue dlxQueue() {
        return QueueBuilder.durable(QUEUE_NAME_DLX).build();
    }

    /**
     * 绑定正常的队列
     *
     * @param queue
     * @param exchange
     * @return
     */

    @Bean
    public Binding normalBing(@Qualifier(value = QUEUE_NAME_NORMAL_BEAN) Queue queue, @Qualifier(EXCHANGE_NAME_NORMAL_Bean) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("normal.#").noargs();

    }

    /**
     * 绑定死信队列
     *
     * @param queue
     * @param exchange
     * @return
     */

    @Bean
    public Binding dlxBing(@Qualifier(value = QUEUE_NAME_DLX_BEAN) Queue queue, @Qualifier(EXCHANGE_NAME_DLX_Bean) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("dlx.#").noargs();

    }

}
