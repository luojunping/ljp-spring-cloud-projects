package com.ljp.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String helloWorld(String name) {
//        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleWithFixedDelay(() -> {
//            System.out.println("hahahah-----------------------");
//        }, 1, 1, TimeUnit.SECONDS);
//        try {
//            TimeUnit.SECONDS.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HELLO WORLD : " + name + "!!!";
    }

    @GetMapping("/gateway")
    public String gateWay(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder stringBuilder = new StringBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            stringBuilder.append(element).append(":").append(request.getParameter(element));
            stringBuilder.append("\r\n");
        }
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            stringBuilder.append(element).append(":").append(request.getHeader(element));
            stringBuilder.append("\r\n");
        }
        return stringBuilder.toString();
    }

    @GetMapping("/path/{path}")
    public String path(HttpServletRequest request, HttpServletResponse response, @PathVariable("path") String path) {
        System.out.println("path = " + path);
        StringBuilder stringBuilder = new StringBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements())
            stringBuilder.append(parameterNames.toString()).append(":").append(parameterNames.nextElement());
        stringBuilder.append("\r\n");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements())
            stringBuilder.append(headerNames.toString()).append(":").append(headerNames.nextElement());
        return stringBuilder.toString();
    }

}
