package com.cloud.olifeadmin.event;

import com.cloud.olifeadmin.entity.ToEmail;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.5.14
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@Component
public class MqSender {

    private static String exchangeName = "olife-notice-exchange";
    private static String routerKeyName = "olife.emergency";

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(Object body){
        rabbitTemplate.convertAndSend(exchangeName,routerKeyName,body);
    }

}
