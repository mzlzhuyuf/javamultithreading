package com.zyf.concurrent.chapter08.threadpool;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter08.threadpool
 * @date 2019/8/19
 * 创建线程工厂
 */
@FunctionalInterface
public interface ThreadFactory {
    Thread createThread(Runnable runnable);
}
