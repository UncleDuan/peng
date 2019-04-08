package net.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class AioServer {

    public static void main(String[] args) throws IOException {  
    	AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open();   
        server.bind(new InetSocketAddress("localhost", 8001));  
        System.out.println("��������8001�˿��غ�");
        
        //��ʼ�ȴ��ͻ������ӣ�һ�������ӣ���26������
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {  
            @Override  
            public void completed(AsynchronousSocketChannel channel, Object attachment) {  
            	 server.accept(null, this); //���������µĿͻ�������
            	 
                 ByteBuffer buffer = ByteBuffer.allocate(1024); //׼����ȡ�ռ�
                 //��ʼ��ȡ�ͻ������ݣ�һ����ȡ��������33������
                 channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                     @Override
                     public void completed(Integer result_num, ByteBuffer attachment) {
                         attachment.flip(); //��ת��Buffer 
                         CharBuffer charBuffer = CharBuffer.allocate(1024);
                         CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
                         decoder.decode(attachment,charBuffer,false);
                         charBuffer.flip();
                         String data = new String(charBuffer.array(),0, charBuffer.limit());
                         System.out.println("client said: " + data);
                         channel.write(ByteBuffer.wrap((data + " 666").getBytes())); //���ؽ�����ͻ���
                         try{
                             channel.close();
                         }catch (Exception e){
                        	 e.printStackTrace();
                         }
                     }
      
                     @Override
                     public void failed(Throwable exc, ByteBuffer attachment) {
                         System.out.println("read error "+exc.getMessage());
                     }
                 });
                 

            }  
  
            @Override  
            public void failed(Throwable exc, Object attachment) {  
                System.out.print("failed: " + exc.getMessage());  
            }  
        });  

        while(true){
        	try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }  
}
