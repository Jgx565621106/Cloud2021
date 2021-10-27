package com.consultest.springcloud.controller;

import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {


  @Value("${server.port}")
  private String serverPort;

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping(value = "/payment/consul")
  public String paymentconsul() {
    return "SpringCloud with consul :" + serverPort + "\t" + UUID.randomUUID().toString();
  }

  @GetMapping(value = "/payment/discovery")
  public Object discovery() {
    List<String> services = discoveryClient.getServices();
    for (String service : services) {
      log.info(service);
    }
    return this.discoveryClient;
  }

}
