package com.cloud.olifeadmin.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.5.14
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@Configuration
public class MqConfig {

//    @Bean
//    public DirectExchange AdvisoryExchange(){
//        return new DirectExchange("olife-advisory-exchange",true,false);
//    }

    @Bean
    public DirectExchange NoticeExchange(){
        return new DirectExchange("olife-notice-exchange",true,false);
    }

    @Bean
    public Queue EmailQueue(){
        Map<String,Object> args = new HashMap<>();
        args.put("x-message-ttl",8000);//设置过期时间8秒
        args.put("x-max-length",20);//最新大消息长度
        return new Queue("olife-email-queue", true,false,false,args);
    }

    @Bean
    public Binding NoticeBinding(){
        return BindingBuilder.bind(EmailQueue()).to(NoticeExchange()).with("olife.emergency");
    }

}
