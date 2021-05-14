package com.cloud.olifeadmin.event;

import com.cloud.olifeadmin.entity.ToEmail;
import com.cloud.olifeadmin.service.MqService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.5.14
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@Slf4j
@Component
public class MqReceiver {

    @Resource
    MqService mqService;

    @RabbitHandler
    @RabbitListener(queues = "olife-email-queue")
    public void EmailReceiver(ToEmail body) throws MessagingException {
        mqService.ReceiveEmail(body);
    }

}
