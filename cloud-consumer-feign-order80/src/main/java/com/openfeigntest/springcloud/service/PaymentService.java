package com.openfeigntest.springcloud.service;

import com.test.springcloud.eneties.CommonResult;
import com.test.springcloud.eneties.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "cloud-payment-service")
public interface PaymentService {

  @GetMapping(value = "/payment/get/{id}")
  CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);


  @GetMapping(value = "/payment/feign/timeout")
  String paymentFeignTimeout();
}
