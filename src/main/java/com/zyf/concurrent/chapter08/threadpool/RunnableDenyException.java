package com.zyf.concurrent.chapter08.threadpool;

/**
 * @author Hero
 * @description com.zyf.concurrent.chapter08.threadpool
 * @date 2019/8/19
 */
public class RunnableDenyException extends RuntimeException {
    public RunnableDenyException(String message) {
        super(message);
    }
}
