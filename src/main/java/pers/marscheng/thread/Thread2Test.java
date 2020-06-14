package pers.marscheng.thread;

/**
 * @version 1.0
 * @className Thread2Test
 * @description 线程测试
 * @author: marscheng
 * @date: 2019-11-24 12:59 PM
 */
public class Thread2Test {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(){
            @Override
            public void run() {
                System.out.println("Hello from new Thread");
            }
        };

        myThread.start();
        Thread.yield();
        //Thread.sleep(1);
        System.out.println("Hello from main Thread");
        myThread.join();

    }
}
