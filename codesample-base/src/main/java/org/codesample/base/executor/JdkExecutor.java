package org.codesample.base.executor;


import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @see java.util.concurrent.Executor
 * @see java.util.concurrent.Executors
 * <ul>
 *     <li>{@link java.util.concurrent.ThreadPoolExecutor} 普通线程池</li>
 *     <li>{@link java.util.concurrent.ForkJoinPool} 工作窃取线程池</li>
 *     <li>{@link java.util.concurrent.ScheduledThreadPoolExecutor}调度线程池</li>
 *     <li></li>
 * </ul>
 * @see java.util.concurrent.ArrayBlockingQueue
 * @see java.util.concurrent.DelayQueue
 */
public class JdkExecutor {

    static class Ele implements Delayed {
        public long getDelay(TimeUnit unit) {
            return 10L;
        }

        public int compareTo(Delayed o) {
            return 0;
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        DelayQueue<Ele> delayQueue = new DelayQueue<Ele>();

        Thread thread = new Thread();
        thread.start();

        JdkExecutor jdkExecutor = JdkExecutor.class.newInstance();
        JdkExecutor instance = JdkExecutor.class.getConstructor().newInstance();
//
    }
}
