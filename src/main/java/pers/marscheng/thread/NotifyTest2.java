package pers.marscheng.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 启动三个线程, 一个输出 1,4,7,10…100, 一个输出 2,5,8,11…101，
 * 最后一个输出3，6，9，12...102 最后 STDOUT 中按序输出 1,2,3,4,5…102
 *
 * @author: marscheng
 * @date: 2019-02-07 11:24 AM
 */
public class NotifyTest2 implements Runnable {
    private Object prev;
    private Object self;
    AtomicInteger i;

    private NotifyTest2(AtomicInteger num,Object prev, Object self) {
        this.i = num;
        this.prev = prev;
        this.self = self;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (prev) {
                synchronized (self) {
                    if (i.get() <= 102) {
                        System.out.println(Thread.currentThread().getName() + ":" + i.get());
                        i.getAndIncrement();
                        self.notify();
                    }
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)  {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        AtomicInteger num = new AtomicInteger(1);
        NotifyTest2 testA = new NotifyTest2(num,c,a);
        NotifyTest2 testB = new NotifyTest2(num,a,b);
        NotifyTest2 testC = new NotifyTest2(num,b,c);

        new Thread(testA).start();
        new Thread(testB).start();
        new Thread(testC).start();
    }
}
