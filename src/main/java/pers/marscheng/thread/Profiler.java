package pers.marscheng.thread;

import java.util.concurrent.TimeUnit;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-07-16 13:04
 **/

public class Profiler {
    private static final ThreadLocal<Long> TIME_THREADLOCL=new ThreadLocal<Long>(){
        @Override
        protected Long initialValue() {
            return System.currentTimeMillis();
        }
    };

    public static final void begin(){
        TIME_THREADLOCL.set(System.currentTimeMillis());
    }

    public static final long end(){
        return System.currentTimeMillis()-TIME_THREADLOCL.get();
    }


    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Profiler.end());
    }

}
