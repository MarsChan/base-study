package pers.marscheng.lock;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * TwinsLock Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Dec 21, 2018</pre>
 */
public class TwinsLockTest {
    @Test
    public void testlock() {
        final Lock lock = new TwinsLock();

        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {

                        TimeUnit.SECONDS.sleep(1);
                        System.out.println(Thread.currentThread().getName());
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("I am in" + Thread.currentThread().getName() + "finally");
                        lock.unlock();
                    }
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            Worker worker = new Worker();
            worker.setDaemon(true);
            worker.start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


} 
