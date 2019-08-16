package com.zyf.concurrent.chapter04.synchronizedDemo;

import java.util.concurrent.TimeUnit;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter04.synchronizedDemo
 * @date 2019/8/15
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 300000;

    private final static Object MUTEX = new Object();

    @Override
    public void run() {
        synchronized (MUTEX) {
            while (index <= MAX) {
                System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(task, "一号窗口");

        Thread windowThread2 = new Thread(task, "二号窗口");

        Thread windowThread3 = new Thread(task, "三号窗口");

        Thread windowThread4 = new Thread(task, "四号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();
    }
}
