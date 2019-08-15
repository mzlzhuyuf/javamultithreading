package com.zyf.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter03
 * @date 2019/8/15
 */
public class InterruptThreadExit {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("I will start work");
                while (!isInterrupted()) {
                    //working.
                }
                System.out.println("I will be exiting.");
            }
        };

        t.start();
        TimeUnit.MINUTES.sleep(1);
        System.out.println("System will be shutdown.");
        t.interrupt();
    }
}
