package pers.marscheng.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * @program: base-study
 * @description: 通过标识位或者中断标志来终止线程
 * @author: Marscheng
 * @create: 2020-07-14 15:02
 **/

public class Shutdown {
    public static void main(String[] args) throws InterruptedException {
        Runner one = new Runner();
        Thread countThread = new Thread(one,"countThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        countThread.interrupt();
        Runner two = new Runner();
        countThread=new Thread(two,"countThread");
        countThread.start();
        TimeUnit.SECONDS.sleep(1);
        two.cancel();

    }

    static class Runner implements Runnable{
        private long i;
        private volatile  boolean on = true;
        @Override
        public void run() {
           while(on&&!Thread.currentThread().isInterrupted()){
               i++;
           }
            System.out.println("COUNT i ="+i);
        }

        public void cancel(){
            on = false;
        }
    }
}
