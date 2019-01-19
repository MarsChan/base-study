package pers.marscheng.thread;

/**
 * @program: base-study
 * @description: 测试voitile
 * @author: MarsCheng
 * @create: 2019-01-14 23:46
 **/
public class Testvolatile {

    public volatile String str = "A";

    public static void main(String args[]){
        Testvolatile t = new Testvolatile();
        Thread t1 = new Thread(){
            @Override
            public void run()
            {
                System.out.println(t.str);
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run()
            {
                t.str = "B";
            }
        };


        t1.start();
        t2.start();
    }
}
