package com.zyf.concurrent.chapter06.threadgroup;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter06.threadgroup
 * @date 2019/8/19
 */
public class ThreadGroupCreator {
    public static void main(String[] args) {
        //1、获取当前线程的group
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        //2、定义一个新的group
        ThreadGroup group1 = new ThreadGroup("Group1");

        //3、程序输出true
        System.out.println(group1.getParent() == currentGroup);

        //4、定义group2，指定group1为其父group
        ThreadGroup group2 = new ThreadGroup(group1, "Group2");

        //5、程序输出true
        System.out.println(group2.getParent() == group1);
    }
}
