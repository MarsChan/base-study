package pers.marscheng.thread.join;

import java.util.concurrent.TimeUnit;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-07-15 16:09
 **/

public class Join {
    public static void main(String[] args) throws InterruptedException {
        Thread previous= Thread.currentThread();
        for(int i=0;i<10;i++){
            Thread thread = new Thread(new Demino(previous),String.valueOf(i));
            thread.start();
            previous=thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName()+" terminate");

    }

    static class Demino implements Runnable{
        private Thread thread;

        public Demino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+" terminate");
        }
    }
}
