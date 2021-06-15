package com.test.springcloud.service.impl;

import com.test.springcloud.dao.PaymentDao;
import com.test.springcloud.eneties.Payment;
import com.test.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

  @Autowired
  private PaymentDao paymentDao;

  public int Create(Payment payment) {
    return paymentDao.Create(payment);
  }

  public Payment getPaymentById(Long id) {
    return paymentDao.getPaymentById(id);
  }
}
