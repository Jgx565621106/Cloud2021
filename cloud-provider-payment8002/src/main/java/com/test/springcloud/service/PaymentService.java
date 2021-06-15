package com.test.springcloud.service;

import com.test.springcloud.eneties.Payment;

public interface PaymentService {

  int Create(Payment payment);

  Payment getPaymentById(Long id);
}
