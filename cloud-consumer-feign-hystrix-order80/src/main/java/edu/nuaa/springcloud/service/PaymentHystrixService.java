package edu.nuaa.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/17 22:14
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
@Component
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable(value = "id")  Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable(value = "id")  Integer id);
}
