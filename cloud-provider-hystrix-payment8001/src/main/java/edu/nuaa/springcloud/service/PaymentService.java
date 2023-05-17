package edu.nuaa.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/17 21:12
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " paymenInfo_OK,id " +id + "\t" + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){
        int timeNumber = 5;
//        int age = 10 / 0;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "线程池: " + Thread.currentThread().getName() + " paymenInfo_Timeout,id " +id + "\t" + "O(∩_∩)O哈哈~耗时" + timeNumber  + "s" ;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池: " + Thread.currentThread().getName() + " paymenInfo_TimeoutHandler,id " +id + "\t" + "o(╥﹏╥)o" ;
    }
}
