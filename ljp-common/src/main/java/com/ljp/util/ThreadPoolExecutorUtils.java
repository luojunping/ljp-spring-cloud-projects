package com.ljp.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/14
 * @since 1.0.0
 **/
public class ThreadPoolExecutorUtils {

    public static final int CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private ThreadPoolExecutorUtils() throws IllegalAccessException {
        throw new IllegalAccessException("ThreadPoolExecutorUtils is not allow create...");
    }

    public static ThreadPoolExecutor create() {
        ThreadPoolExecutor threadPoolExecutor = Builder.build();
        return Builder.build();
    }

    private static class Builder {

        private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_SIZE, CORE_SIZE << 1, 180L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2000), new ThreadPoolExecutor.CallerRunsPolicy());

        public static ThreadPoolExecutor build() {
            return threadPoolExecutor;
        }

    }

}
