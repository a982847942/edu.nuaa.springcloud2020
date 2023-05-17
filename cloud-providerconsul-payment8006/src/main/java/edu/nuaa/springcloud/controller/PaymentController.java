package edu.nuaa.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/17 9:28
 */
@RestController
@Slf4j
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String paymentZK(){
        return "springcloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
