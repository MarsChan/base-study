package pers.marscheng.lock;

import jdk.nashorn.internal.scripts.JO;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: base-study
 * @description: 公平锁和非公平锁测试
 * @author: MarsCheng
 * @create: 2018-12-24 15:51
 **/
public class FairAndUnfalrTest {
    private static class ReentrantLock2 extends ReentrantLock {
        public ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        public List<Thread> getQueuedThreads() {
            List<Thread> threads = new ArrayList<>(super.getQueuedThreads());
            Collections.reverse(threads);
            return threads;
        }
    }

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unfairLock = new ReentrantLock2(false);
    private static CountDownLatch start;

    private static class Job extends Thread {
        ReentrantLock2 lock;

        public Job(Lock lock) {
            this.lock = (ReentrantLock2) lock;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
            }
            for (int i = 0; i < 2; i++) {
                try {
                    lock.lock();
                    System.out.println("lock by " + Thread.currentThread().getName());
                    System.out.print("thread in queue are [");
                    for (Thread thread : lock.getQueuedThreads()) {
                        System.out.print(thread.getName()+",");
                    }
                    System.out.println("]");
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    @Test
    public void testFair() {
        doJob(fairLock);
    }

    @Test
    public void testUnfair() {
        doJob(unfairLock);
    }

    private void doJob(Lock lock) {
        start = new CountDownLatch(1);
        for (int i = 0; i < 5; i++) {
            Thread job = new Job(lock);
            job.setName(String.valueOf(i));
            job.start();
        }
        start.countDown();
    }

}
