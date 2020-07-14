package pers.marscheng.thread.wait;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-07-14 16:51
 **/

public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                // 当条件不满足时，继续wait，同时释放了lock的锁
                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true. wait @ " + DateFormatUtils.format(new Date(), "HH:mm:ss"));
                        lock.wait();
                    } catch (InterruptedException e) {
                    }
                }
                // 条件满足时，完成工作
                System.out.println(Thread.currentThread() + " flag is false. running @ " + DateFormatUtils.format(new Date(), "HH:mm:ss"));
            }

        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                // 当条件不满足时，继续wait，同时释放了lock的锁
                try {
                    // 获取lock的锁，然后进行通知，通知时不会释放lock的锁，
                    // 直到当前线程释放了lock后，WaitThread才能从wait方法中返回
                    System.out.println(Thread.currentThread() + " hold lock.notify  @ " + DateFormatUtils.format(new Date(), "HH:mm:ss"));
                    lock.notifyAll();
                    flag = false;
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                }
            }
            //再次加锁
            synchronized (lock) {
                System.out.println(Thread.currentThread() + " hold lock again. sleep @ " +  DateFormatUtils.format(new Date(), "HH:mm:ss"));
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
