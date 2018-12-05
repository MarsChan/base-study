package pers.marscheng.thread;

import java.util.concurrent.*;

/**
 * @program: base-study
 * @description: 线程池demo
 * @author: MarsCheng
 * @create: 2018-12-04 09:29
 **/
public class ThreadPoolDemo {
    public static class MyTask implements Runnable {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread ID:"
                    + Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        for (int i = 0; i < 10; i++) {
            es.submit(myTask);
        }
    }
}
