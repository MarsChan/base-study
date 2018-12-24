package pers.marscheng.thread;

/**
 * @program: base-study
 * @description: 测试线程
 * @author: MarsCheng
 * @create: 2018-11-30 23:51
 **/
public class ThreadTest extends Thread {
    private String name;

    public ThreadTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (this.name.equals("t1")) {
            this.method1();
        } else {
            this.method2();
        }
    }

    int a = 0;
    volatile int b = 0;

    public void method1() {
        int r2 = a;
        b = 1;
        System.out.println("r2=" + r2);
    }

    public void method2() {
        int r1 = b;
        a = 2;
        System.out.println("r1=" + r1);
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest("t1");
        ThreadTest t2 = new ThreadTest("t2");

        t1.start();
        t2.start();

    }

}
