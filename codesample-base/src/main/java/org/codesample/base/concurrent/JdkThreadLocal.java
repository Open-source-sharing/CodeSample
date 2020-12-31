package org.codesample.base.concurrent;

/**
 * @see ThreadLocal
 */
public class JdkThreadLocal {


    public static void main(String[] args) {
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();
        threadLocal.set("a");
        Object o = threadLocal.get();
    }
}


