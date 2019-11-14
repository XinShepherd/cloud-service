package com.noteam.cloud.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2019/11/13.
 *
 * @author Shepherd
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class HelloController {

    private final DiscoveryClient client;

    @GetMapping("/hello")
    public String index() {
        List<ServiceInstance> instances = client.getInstances("hello-service");
        for (ServiceInstance instance : instances) {
            log.info("Hello host: {}, serviceId: {}", instance.getHost(), instance.getServiceId());
        }
        return "Hello world";
    }

}
