package com.ljp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.servlet.annotation.WebServlet;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/2/27
 * @since 1.0.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableAspectJAutoProxy(exposeProxy = true)
@ServletComponentScan
@WebServlet(urlPatterns = {"*.jsp"}, name = "JspServlet")
public class Server9097Application {

    public static void main(String[] args) {
        SpringApplication.run(Server9097Application.class, args);
    }

}
