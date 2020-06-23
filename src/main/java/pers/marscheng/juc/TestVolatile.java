package pers.marscheng.juc;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-05-13 15:59
 **/

public class TestVolatile extends Thread {
    private static boolean flag = false;

    public void run() {
        while (!flag) ;
        System.out.println("run方法退出了");
    }

    public static void main(String[] args) throws Exception {
        new TestVolatile().start();
        Thread.sleep(5000);
        flag = true;
    }
}