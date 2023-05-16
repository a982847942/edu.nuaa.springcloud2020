package edu.nuaa.springcloud.service.impl;

import edu.nuaa.springcloud.dao.PaymentDao;
import edu.nuaa.springcloud.entities.Payment;
import edu.nuaa.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/16 9:25
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
