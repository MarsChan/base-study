package pers.marscheng.thread.tool;

import java.util.concurrent.CyclicBarrier;

/**
 * @version 1.0
 * @className CyclicBarrierTest2
 * @description
 * @author: marscheng
 * @date: 2020-09-06 3:38 PM
 */
public class CyclicBarrierTest2 {
    static CyclicBarrier c = new CyclicBarrier(2,new printA());

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(1);
            try {
                c.await(); //插入屏障
            }catch (Exception e){
            }
        }).start();

        System.out.println(2);

        try {
            c.await(); //插入屏障
        }catch (Exception e){
        }
    }

    private static class printA implements Runnable {
        @Override
        public void run() {
            System.out.println(3);
        }
    }
}
