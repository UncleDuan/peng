package net.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static String ROOT="C:\\Users\\ionolab-DP\\IdeaProjects\\peng\\";
    public static String defaultPage="index.html";

    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8000);
        while (true){
            Socket sc=server.accept();
            System.out.println("Accepting Connection...");
            new HttpThread(sc).start();
        }
    }

    static class HttpThread extends Thread{
        private  Socket socket;
        public HttpThread(Socket sc){
            this.socket=sc;
        }


        @Override
        public void run(){
            InputStream ins=null;
            OutputStream outs=null;
            try {
                ins=socket.getInputStream();
                outs=socket.getOutputStream();
                Receive rcv=new Receive(ins);
                String sURL=rcv.parse();
                if (sURL.equals("/")){
                    sURL=HttpServer.defaultPage;
                }
                Answer ans=new Answer(outs);
                ans.send(sURL);

            } catch (IOException e) {
                System.out.println(e.toString());
            }
            finally {
                try {
                    if (ins != null) {
                        ins.close();
                    }
                    if (outs != null) {
                        outs.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
