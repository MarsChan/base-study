package pers.marscheng.thread.connectionpool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @program: base-study
 * @description: 数据库连接驱动
 * @author: Marscheng
 * @create: 2020-07-21 15:13
 **/

public class ConnectionDriver {
    static class ConnectionHandler implements InvocationHandler {

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("commit")) {
//                System.out.println("begin to sleep before commit");
                TimeUnit.MILLISECONDS.sleep(100);
//                System.out.println("sleep over");

            }
            return null;
        }
    }

    public static final Connection createConnection() {
        return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(), new Class[]{Connection.class}, new ConnectionHandler());
    }
}
