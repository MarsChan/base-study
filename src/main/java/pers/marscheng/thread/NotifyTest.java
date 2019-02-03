package pers.marscheng.thread;

import java.util.ArrayList;

/**
 * @program: base-study
 * @description: notify测试
 * @author: MarsCheng
 * @create: 2019-02-03 10:38
 **/
public class NotifyTest {
    public static void main(String[] args){
         final Thread t1 = new Thread(){
           int[] arrys = {1,3,5,7,9};

            @Override
            public void run() {
                for (int i:arrys){
                    System.out.print(i);
                    try {
                        Thread.currentThread().wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Thread.currentThread().interrupt();
            }
        };

        Thread t2 = new Thread(){
            int[] arrys = {2,4,6,8,10};

            @Override
            public void run() {
                for (int i:arrys){
                    System.out.print(i);
                    try {
                        Thread.currentThread().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread.currentThread().interrupt();
            }
        };

        t1.start();
        t2.start();

        while (!(t1.isInterrupted())){
            t1.notify();
        }

        while (!(t2.isInterrupted())){
            t2.notify();
        }
    }
}
