package edu.nuaa.springcloud.service;

import edu.nuaa.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/16 9:25
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
