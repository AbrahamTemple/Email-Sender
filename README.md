# SpringBoot结合RabbitMQ发送邮件

## 演示结果
![Screenshot](docs/demo.png)

## 请求代码
``` java
@RequestMapping("/mq/{email}")
 public RestResponse<String> test(@PathVariable("email") String email){
  String[] tos = {email};
  ToEmail toEmail = new ToEmail(tos, "OLife注册即可安心养老", "app下载的网址:https://github.com/AbrahamTemple/O-Life");
  return new RestResponse<String>(HttpStatus.OK.value(), HttpStatus.OK.toString(),mqService.SendEmail(toEmail));
}
```
