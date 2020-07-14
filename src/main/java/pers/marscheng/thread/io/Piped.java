package pers.marscheng.thread.io;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @program: base-study
 * @description:
 * @author: Marscheng
 * @create: 2020-07-14 18:40
 **/

public class Piped {
    public static void main(String[] args) throws IOException {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        out.connect(in);
        Thread printThread = new Thread(new Print(in),"PrintThread");
        printThread.start();
        int receive = 0;

        try {
            while ((receive = System.in.read()) != -1) {
                out.write(receive);
            }
        } finally {
            out.close();
        }
    }

    static class Print implements Runnable{
        private PipedReader in ;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
            int receive = 0;

            while(true){
                try {
                    if ((receive=in.read())!=-1)
                        System.out.println(receive);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
