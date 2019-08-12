package com.zyf.concurrent.chapter03;

import java.util.stream.IntStream;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter03
 * @date 2019/8/12
 */
public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() -> {
            //if (index == 0)
            //  Thread.yield();
            System.out.println(index);
        });
    }
}
