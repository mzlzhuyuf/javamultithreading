package com.zyf.concurrent.chapter04.minitor;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter04.minitor
 * @date 2019/8/16
 */
public class ClassMontior {

    public static synchronized void method1() {
        System.out.println(currentThread().getName() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        System.out.println(currentThread().getName() + " enter to method2");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(ClassMontior::method1, "T1").start();
        new Thread(ClassMontior::method2, "T2").start();
    }
}
