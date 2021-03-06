package com.zyf.concurrent.chapter03;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter03
 * @date 2019/8/14
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        //1、定义两个线程，并保存在threads中
        List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(Collectors.toList());

        //2、启动这个线程
        threads.forEach(Thread::start);

        //3、执行这两个线程的join方法
        for (Thread thread : threads) {
            thread.join();
        }

        //4、main线程循环输出
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "#" + i);
            shortSleep();
        }

    }

    /**
     * 构造一个简单的线程，每个线程只是简单的循环输出
     *
     * @param seq
     * @return
     */
    private static Thread create(int seq) {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "#" + i);
                shortSleep();
            }
        }, String.valueOf(seq));
    }

    private static void shortSleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
