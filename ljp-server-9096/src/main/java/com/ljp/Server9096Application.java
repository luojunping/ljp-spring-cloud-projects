package com.ljp;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Server9096Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Server9096Application.class).web(WebApplicationType.SERVLET).run(args);
    }

}
