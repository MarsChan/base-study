package pers.marscheng.rpc;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端
 *
 * @author: marscheng
 * @date: 2019-06-11 9:59 PM
 */
public class Server {
    /**
     * zookeeper服务注册更节点
     */
    public static final String ZOOKEEPER_NODE = "root";

    /**
     * 服务本地注册容器
     */
    private Map<String,Object> serverRegister = new HashMap<>();

    private ServerSocket serverSocket = null;

    private ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime()
            .availableProcessors());

       public void start(String address,int port) throws IOException {
           serverSocket = new ServerSocket();
           //serverSocket.se
       }

    public void register(){

    }
}


