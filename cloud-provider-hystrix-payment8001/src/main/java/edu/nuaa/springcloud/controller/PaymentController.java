package edu.nuaa.springcloud.controller;

import edu.nuaa.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/17 21:16
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable(value = "id")  Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("******result: " + result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable(value = "id")  Integer id){
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("******result: " + result);
        return result;
    }
}
