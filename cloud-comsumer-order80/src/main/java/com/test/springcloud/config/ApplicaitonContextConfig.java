package com.test.springcloud.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicaitonContextConfig {

  @Bean
  @LoadBalanced //使用@LoadBalanced注解赋予RestTemplete负载均衡的能力
  public RestTemplate getRestTemplate() {
    return new RestTemplate();
  }
}
