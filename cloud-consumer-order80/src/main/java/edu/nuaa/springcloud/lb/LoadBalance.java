package edu.nuaa.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author brain
 * @version 1.0
 * @date 2023/5/17 14:12
 */
public interface LoadBalance {
    ServiceInstance instance(List<ServiceInstance> serviceInstances);
}
