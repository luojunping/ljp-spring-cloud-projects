package com.ljp.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/1/31
 * @since 1.0.0
 **/
public class CommandHello extends HystrixCommand<String> {

    private final String name;

    public CommandHello(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("CommandHello"));
        this.name = name;
    }

    public static void main(String[] args) {
        CommandHello commandHello = new CommandHello("world");
        String result = commandHello.execute();
        System.out.println("result = " + result);
    }

    @Override
    protected String run() throws Exception {
        return "hello" + name + " !!!";
    }

}
