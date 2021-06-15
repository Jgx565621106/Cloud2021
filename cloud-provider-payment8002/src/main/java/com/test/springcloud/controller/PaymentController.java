package com.test.springcloud.controller;

import com.test.springcloud.eneties.CommonResult;
import com.test.springcloud.eneties.Payment;
import com.test.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @Value("${server.port}")
  private String serverPort;

  @PostMapping(value = "/payment/create")
  public CommonResult create(@RequestBody Payment payment) {
    int result = paymentService.Create(payment);
    log.info("********插入结果：" + result);
    if (result > 0) {
      return new CommonResult(200, "插入数据成功,serverPort: " + serverPort, result);
    } else {
      return new CommonResult(400, "插入数据失败", result);
    }
  }

  @GetMapping(value = "/payment/get/{id}")
  public CommonResult getPaymentById(@PathVariable("id") Long id) {
    Payment payment = paymentService.getPaymentById(id);
    log.info("********查询结果：" + payment + "         1111111111");
    if (payment != null) {
      return new CommonResult(200, "查询数据成功,serverPort: " + serverPort, payment);
    } else {
      return new CommonResult(400, "没有当前记录", payment);
    }
  }
}
