package pers.marscheng.thread.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: base-study
 * @description: 连接池测试
 * @author: Marscheng
 * @create: 2020-07-21 15:49
 **/

public class ConnectionPoolTest {
    static ConnectionPool pool= new ConnectionPool(10);
    // 保证所有ConnectionRunner能够同时开始
    static CountDownLatch start = new CountDownLatch(1);
    // main线程将会等待所有ConnectionRunner结束后才能继续执行
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        int threadCount = 30;
        end = new CountDownLatch(threadCount);
        int count = 20;

        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot =new AtomicInteger();;

        for (int i = 0;i<threadCount;i++){
            Thread thread = new Thread(new ConnetionRunner(count, got, notGot),"ConnectionRunnerThread");
            thread.start();
        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection:  " + got);
        System.out.println("not got connection " + notGot);
    }

    static class ConnetionRunner implements Runnable{
        int        count;
        AtomicInteger    got;
        AtomicInteger    notGot;

        public ConnetionRunner(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (count>0){
                try {
                    // 从线程池中获取连接，如果1000ms内无法获取到，将会返回null
                    // 分别统计连接获取的数量got和未获取到的数量notGot
                    Connection connection = pool.fetchConnection(1000);
                    if(connection!=null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else{
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();


        }
    }

}
