package net.webserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Answer {
    OutputStream outs=null;

    public Answer(OutputStream outs){
        this.outs=outs;
    }

    public void send(String pageFile) throws IOException {
        byte[] bytes=new byte[2048];
        FileInputStream fls=null;
        try {
            File file = new File(HttpServer.ROOT, pageFile);
            if (file.exists()) {
                int ch = fls.read(bytes, 0, 2048);
                String sBody = new String(bytes);
                String sendMessage = "HTTP/1.1 200 OK\r\n" +
                        "Content-Type:text/html\r\n" +
                        "\r\n" +
                        sBody;
                outs.write(sendMessage.getBytes());
            } else {
                String errorMessage = "HTTP/1.1 404 File Not Found\r\n" +
                        "Content-Type:text/html\r\n" +
                        "Content-Length: 23\r\n" +
                        "\r\n" +
                        "<h1>File Not Found</h1>";
                outs.write(errorMessage.getBytes());
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (fls!=null){fls.close();}
        }
    }
}
