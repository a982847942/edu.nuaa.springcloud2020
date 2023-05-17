package edu.nuaa.springcloud.controller;

import edu.nuaa.springcloud.entities.CommonResult;
import edu.nuaa.springcloud.entities.Payment;
import edu.nuaa.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/16 9:28
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果: " + result);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort: " + serverPort + "  ",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****插入结果: " + payment);
        if (payment != null){
            return new CommonResult(200,"查询数据库成功,serverPort: " + serverPort + "  ",payment);
        }else {
            return new CommonResult(444,"没有对应记录,查询ID: " + id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
