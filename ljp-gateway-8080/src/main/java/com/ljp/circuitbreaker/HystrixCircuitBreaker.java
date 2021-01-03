package com.ljp.circuitbreaker;

import com.netflix.hystrix.HystrixCommand;

public class HystrixCircuitBreaker extends HystrixCommand {

    protected HystrixCircuitBreaker(Setter setter) {
        super(setter);
    }

    @Override
    protected Object run() throws Exception {
        return null;
    }

}
