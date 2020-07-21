package com.zyf.concurrent.chapter08.threadpool;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter08.threadpool
 * @date 2019/8/19
 */
public class InternalTask implements Runnable {
    //private final RunnableQueue runnableQueue;

    private volatile boolean running = true;

    /*public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }*/

    @Override
    public void run() {
        //如果当前任务为running并且没有被中断，则其将不断地从queue中获取runnable，然后执行run方法
        while (running && !Thread.currentThread().isInterrupted()) {
            Runnable task = null;
            /*try {
                task = runnableQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.run();*/
        }
    }

    //停止当前任务，主要会在线程池的shutdown方法中使用
    public void stop() {
        this.running = false;
    }
}
