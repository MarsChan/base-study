package pers.marscheng.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * confition测试
 *
 * @author: marscheng
 * @date: 2019-02-07 10:52 AM
 */
public class ConditionTest implements Runnable{
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    int i = 1;

    @Override
    public void run() {
        try {
            lock.lock();
            while (true) {
                condition.signal();
                if (i <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    i++;
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ConditionTest test = new ConditionTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);

        t1.start();
        t2.start();


    }


}
