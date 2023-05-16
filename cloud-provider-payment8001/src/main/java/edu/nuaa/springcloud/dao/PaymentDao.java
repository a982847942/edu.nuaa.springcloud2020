package edu.nuaa.springcloud.dao;

import edu.nuaa.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/16 9:06
 */
@Mapper
//@Repository
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
