package pers.marscheng.thread;

/**
 * notify错误示范
 *
 * @author: marscheng
 * @date: 2019-02-07 10:18 AM
 */
public class NotifyErrorTest {
    private int i = 1;

    Thread t1 = new Thread(){

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    System.out.println(this.getClass());
                    notify();
                    if (i <= 100) {
                        System.out.println(currentThread().getName() + ":" + i);
                        i++;
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    };

    Thread t2 = new Thread(){

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    System.out.println(this.getClass());
                    notify();
                    if (i <= 100) {
                        System.out.println(currentThread().getName() + ":" + i);
                        i++;
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    };

    public static void main(String[] args){
        NotifyErrorTest test = new NotifyErrorTest();

        test.t1.start();
        test.t2.start();
    }
}
