package edu.nuaa.springcloud.controller;

import edu.nuaa.springcloud.entities.CommonResult;
import edu.nuaa.springcloud.entities.Payment;
import edu.nuaa.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/17 19:44
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
