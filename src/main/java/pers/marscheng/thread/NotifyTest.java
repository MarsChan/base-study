package pers.marscheng.thread;

/**
 * @program: base-study
 * @description: notify测试
 * @author: MarsCheng
 * @create: 2019-02-03 10:38
 **/
public class NotifyTest implements Runnable {
    int i = 1;


    public static void main(String[] args) {
        NotifyTest test = new NotifyTest();
        Thread t1 = new Thread(test);
        Thread t2 = new Thread(test);

        t1.start();
        t2.start();


    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                this.notify();
                if (i <= 100) {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + ":" + i);
                    i++;
                    try {
                        this.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
