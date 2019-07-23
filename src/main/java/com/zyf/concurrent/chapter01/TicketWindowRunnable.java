package com.zyf.concurrent.chapter01;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter01
 * @date 2019/7/22
 * Thread模拟营业大厅叫号机程序
 */
public class TicketWindowRunnable implements Runnable {

    //最多受理50笔业务
    private static final int MAX = 50;

    private int index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是：" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
