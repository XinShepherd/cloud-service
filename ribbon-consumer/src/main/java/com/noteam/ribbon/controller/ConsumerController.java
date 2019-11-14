package com.noteam.ribbon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2019/11/14.
 *
 * @author Shepherd
 */
@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final RestTemplate restTemplate;

    @GetMapping("/ribbon-consumer")
    public String helloConsumer() {
        return restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class)
                .getBody();
    }

}
