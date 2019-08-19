package com.zyf.concurrent.chapter05.booleanlock;

import java.util.List;
import java.util.concurrent.TimeoutException;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter05.booleanlock
 * @date 2019/8/19
 */
public interface Lock {
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeoutException;

    void unlock();

    List<Thread> getBlockedThreads();
}
