package com.test.springcloud.dao;

import com.test.springcloud.eneties.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface PaymentDao {

  @Insert({
      "<script>",
      "insert into payment (serial) values ",
      "(#{serial})",
      "</script>"
  })
  int Create(Payment payment);

  @Select("select * from payment where id = #{id}")
  @Results({
      @Result(property = "id", column = "id"),
      @Result(property = "serial", column = "serial")
  })
  Payment getPaymentById(Long id);
}
