package com.cloud.olifeadmin.service;

import com.cloud.olifeadmin.entity.ToEmail;
import com.cloud.olifeadmin.event.MqReceiver;
import com.cloud.olifeadmin.event.MqSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.5.14
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@Service
public class MqService {

    @Resource
    MqSender mqSender;

    @Resource
    MailService mailService;

    public String SendEmail(ToEmail email){
        mqSender.send(email);
        return "共有"+email.getTos().length+"封邮箱成功发出";
    }

    public void ReceiveEmail(ToEmail body) throws MessagingException {
        mailService.htmlEmail(body);
    }

}
