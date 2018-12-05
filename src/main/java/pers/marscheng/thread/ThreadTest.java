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
    public void run(){
        for(int i=0 ;i<1000000;i++){
            System.out.println(name+"-"+i);
        }
    }
}
