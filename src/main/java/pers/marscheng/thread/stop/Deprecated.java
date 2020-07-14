package pers.marscheng.thread.stop;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-07-14 11:33
 **/

public class Deprecated {
    public static void main(String[] args) throws InterruptedException {

        Thread printThread = new Thread(new Runner(),"printThread");

        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);
        //暂停
        printThread.suspend();
        System.out.println("main suspend PrintThread at"+DateFormatUtils.format(new Date(), "HH:mm:ss"));
        TimeUnit.SECONDS.sleep(3);
        //恢复
        printThread.resume();
        System.out.println("main resume PrintThread at " + DateFormatUtils.format(new Date(), "HH:mm:ss"));
        TimeUnit.SECONDS.sleep(3);
        //停止
        printThread.stop();
        System.out.println("main stop PrintThread at " + DateFormatUtils.format(new Date(), "HH:mm:ss"));
        TimeUnit.SECONDS.sleep(3);
    }

    static class Runner implements Runnable{
        @Override
        public void run() {
            while (true){
                System.out.println(Thread.currentThread().getName()+"run at"+ DateFormatUtils.format(new Date(), "HH:mm:ss"));
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
