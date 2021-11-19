package com.ljp.test.operation;

import com.google.common.collect.Lists;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 罗俊平
 * @email 591402399@qq.com
 * @date 2021/3/6
 * @since 1.0.0
 **/
public class BitTest {

    private static final ReentrantLock reentrantLock = new ReentrantLock();
    private static final Condition condition = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        Lists.newArrayList("0", "0", "0", "0", "0", "0", "0", "0");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(20));
        threadPoolExecutor.execute(() -> {
            try {
                reentrantLock.lock();
                condition.await(3, TimeUnit.SECONDS);
                condition.await();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "6666");

        });
        threadPoolExecutor.execute(() -> {
            reentrantLock.lock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            System.out.println(Thread.currentThread().getName() + "888");
        });
        threadPoolExecutor.shutdown();

    }

}
