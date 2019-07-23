package com.zyf.concurrent.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter01
 * @date 2019/7/22
 */
public class TryConcurrency {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                enjoyMusic();
            }
        }.start();
        browseNews();
    }

    private static void browseNews() {
        for (; ; ) {
            System.out.println("Uh-huh, the good news.");
            sleep(1);
        }
    }

    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("Uh-huh, the nice music.");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
