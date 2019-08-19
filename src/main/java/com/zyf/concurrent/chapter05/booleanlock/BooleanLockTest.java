package com.zyf.concurrent.chapter05.booleanlock;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter05.booleanlock
 * @date 2019/8/19
 */
public class BooleanLockTest {
    //定义 BooleanLock
    private final Lock lock = new BooleanLock();

    //使用try..finally语句块确保lock每次都能被正确释放
    public void syncMethod() {
        //加锁
        try {
            lock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BooleanLockTest blt = new BooleanLockTest();
        //定义一个线程并且启动
        IntStream.range(0, 10).mapToObj(i -> new Thread(blt::syncMethod)).forEach(Thread::start);
    }
}
