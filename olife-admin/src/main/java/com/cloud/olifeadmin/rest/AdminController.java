package com.cloud.olifeadmin.rest;

import com.cloud.olifeadmin.entity.ToEmail;
import com.cloud.olifeadmin.event.MqSender;
import com.cloud.olifeadmin.vo.RestResponse;
import com.cloud.olifeadmin.service.MqService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 6.1.8
 * @author: Abraham Vong
 * @date: 2021.5.14
 * @GitHub https://github.com/AbrahamTemple/
 * @description:
 */
@RestController
public class AdminController {

    @Resource
    MqService mqService;

    @RequestMapping("/mq/{email}")
    public RestResponse<String> test(@PathVariable("email") String email){
        String[] tos = {email};
        ToEmail toEmail = new ToEmail(tos, "OLife注册即可安心养老", "app下载的网址:https://github.com/AbrahamTemple/O-Life");
        return new RestResponse<String>(HttpStatus.OK.value(), HttpStatus.OK.toString(),mqService.SendEmail(toEmail));
    }
}
