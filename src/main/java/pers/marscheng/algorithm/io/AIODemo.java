package pers.marscheng.algorithm.io;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: base-study
 * @description: aio demo
 * @author: MarsCheng
 * @create: 2018-12-05 16:26
 **/
public class AIODemo {
    public void testFuture(){
        Path path = Paths.get("/Users/chengj001/Documents/工作文件/招商金科/工作/业务员品质管理系统材料 2/系统环境地址.docx");
        try {
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            Future future = channel.read(buffer, 0);
            while (!future.isDone()) {
                System.out.println("I'm idle");
            }

            Integer readNumber = (Integer) future.get();


            buffer.flip();
            CharBuffer charBuffer = CharBuffer.allocate(1024);
            CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
            decoder.decode(buffer, charBuffer, false);
            charBuffer.flip();
            String data = new String(charBuffer.array(), 0, charBuffer.limit());
            System.out.println("read number:" + readNumber);
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String testCompletionHandler(){
        Path path = Paths.get("/Users/chengj001/Documents/工作文件/招商金科/工作/业务员品质管理系统材料 2/系统环境地址.docx");
        AsynchronousFileChannel channel = null;
        try {
            channel = AsynchronousFileChannel.open(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer, 0, buffer, new CompletionHandler() {
            @Override
            public void completed(Object result, Object attachment) {
                System.out.println(Thread.currentThread().getName() + " read success!");
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                System.out.println("read error");
            }

        });

        return "上传成功";
    }

    public static void main(String[] args) {
        AIODemo demo = new AIODemo();
        System.out.println(demo.testCompletionHandler());

        while (true){
            System.out.println(Thread.currentThread().getName() + " sleep");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
