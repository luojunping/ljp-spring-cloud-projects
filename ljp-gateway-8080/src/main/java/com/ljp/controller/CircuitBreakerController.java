package com.ljp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    @GetMapping("/fallback")
    public String fallback() {
        return "fallback";
    }

}
