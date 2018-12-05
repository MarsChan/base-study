package pers.marscheng.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: base-study
 * @description: 测试ReentrantLock
 * @author: MarsCheng
 * @create: 2018-12-03 13:51
 **/
public class TestReentrantLock implements Runnable{
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();

    int lock;

    public TestReentrantLock(int lock)
    {
        this.lock = lock;
    }

    @Override
    public void run()
    {
        try
        {
            if (lock == 1)
            {
                lock1.lockInterruptibly();
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {
                    // TODO: handle exception
                }
                lock2.lockInterruptibly();
            }
            else
            {
                lock2.lockInterruptibly();
                try
                {
                    Thread.sleep(500);
                }
                catch (Exception e)
                {
                    // TODO: handle exception
                }
                lock1.lockInterruptibly();
            }
        }
        catch (Exception e)
        {
            // TODO: handle exception
        }
        finally
        {
            if (lock1.isHeldByCurrentThread())
            {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread())
            {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        TestReentrantLock t1 = new TestReentrantLock(1);
        TestReentrantLock t2 = new TestReentrantLock(2);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();
        Thread.sleep(1000);
//        DeadlockChecker.check();
    }

    static class DeadlockChecker
    {
        private final static ThreadMXBean mbean = ManagementFactory.getThreadMXBean();
        final static Runnable deadlockChecker = new Runnable()
        {
            @Override
            public void run()
            {
                // TODO Auto-generated method stub
                while (true)
                {
                    long[] deadlockedThreadIds = mbean.findDeadlockedThreads();
                    if (deadlockedThreadIds != null)
                    {
                        ThreadInfo[] threadInfos = mbean.getThreadInfo(deadlockedThreadIds);
                        for (Thread t : Thread.getAllStackTraces().keySet())
                        {
                            for (int i = 0; i < threadInfos.length; i++)
                            {
                                if(t.getId() == threadInfos[i].getThreadId())
                                {
                                    t.interrupt();
                                }
                            }
                        }
                    }
                    try
                    {
                        Thread.sleep(5000);
                    }
                    catch (Exception e)
                    {
                        // TODO: handle exception
                    }
                }

            }
        };

        public static void check()
        {
            Thread t = new Thread(deadlockChecker);
            t.setDaemon(true);
            t.start();
        }
    }
}
