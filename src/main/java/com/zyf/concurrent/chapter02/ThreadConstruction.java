package com.zyf.concurrent.chapter02;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter02
 * @date 2019/7/22
 * Thread与ThreadGroup
 */
public class ThreadConstruction {
    public static void main(String[] args) {
        //创建了一个Thread t1
        Thread t1 = new Thread("t1");

        //创建了一个ThreadGroup
        ThreadGroup group = new ThreadGroup("TestGroup");

        //创建了一个Thread t2，并且将它加入到了group中
        Thread t2 = new Thread(group, "t2");
        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main thread belong group:" + mainThreadGroup.getName());
        System.out.println("t1 and main belong the same group:" + (mainThreadGroup == t1.getThreadGroup()));
        System.out.println("t2 thread group not belong main group:" + (mainThreadGroup == t2.getThreadGroup()));
        System.out.println("t2 thread group belong main TestGroup:" + (group == t2.getThreadGroup()));

    }
}
