package com.openfeigntest.springcloud.controller;

import com.openfeigntest.springcloud.service.PaymentService;
import com.test.springcloud.eneties.CommonResult;
import com.test.springcloud.eneties.Payment;
import feign.Param;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderFeignController {

  @Autowired
  private PaymentService paymentService;

  @GetMapping(value = "/consumer/payment/get/{id}")
  public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
    return paymentService.getPaymentById(id);
  }


  @GetMapping(value = "/consumer/payment/feign/timeout")
  public String getPaymentById() {
    return paymentService.paymentFeignTimeout();
  }


}
