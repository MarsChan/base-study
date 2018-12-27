package pers.marscheng.thread;

/**
 * @program: base-study
 * @description: 测试线程join方法
 * @author: MarsCheng
 * @create: 2018-11-30 19:43
 **/
public class JoinTest {
    public volatile static int i = 0;

    public static class AddThread extends Thread
    {
        @Override
        public void run()
        {
            for (i = 0; i < 10000000; i++)
                ;
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
//        AddThread at = new AddThread();
//        //只是让子线程处于就绪状态，如果子线程是要进行大量耗时运算，主线程往往会在子线程之前结束
//        at.start();
//        //会先暂停主线程，等待at子线程执行完之后才会继续执行
//        at.join();
//        System.out.println(i);

        ThreadTest t1 = new ThreadTest("t1");
        ThreadTest t2 = new ThreadTest("t2");

        t1.start();
        //在这个位置才能让t2阻塞，因为还没执行到t2
        t1.join();
        t2.start();
        //join只会让主线程挂起，所以没办法阻塞t2,因为这时候主线程已经让t2启动了
//        t1.join();

    }
}
