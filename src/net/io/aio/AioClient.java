package net.io.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.UUID;


public class AioClient {

	public static void main(String[] a) {
		try
		{
			AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();
			
			//18�����ӳɹ����Զ���20������
			channel.connect(new InetSocketAddress("localhost", 8001), null, new CompletionHandler<Void, Void>() {

				public void completed(Void result, Void attachment) {
					String str = UUID.randomUUID().toString();
					
					//24���������д���ݳɹ����Զ���28������
					channel.write(ByteBuffer.wrap(str.getBytes()), null,
							new CompletionHandler<Integer, Object>() {

								@Override
								public void completed(Integer result, Object attachment) {
									try {
										System.out.println("write " + str + ", and wait response");
										//�ȴ���������Ӧ
										ByteBuffer buffer = ByteBuffer.allocate(1024); //׼����ȡ�ռ�
						                 //��ʼ��ȡ�������������ݣ�һ����ȡ��������39������
										channel.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
						                     @Override
						                     public void completed(Integer result_num, ByteBuffer attachment) {
						                         attachment.flip(); //��ת��Buffer 
						                         CharBuffer charBuffer = CharBuffer.allocate(1024);
						                         CharsetDecoder decoder = Charset.defaultCharset().newDecoder();
						                         decoder.decode(attachment,charBuffer,false);
						                         charBuffer.flip();
						                         String data = new String(charBuffer.array(),0, charBuffer.limit());
						                         System.out.println("server said: " + data);
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
						                 
										channel.close();
									} catch (Exception e) {
										e.printStackTrace();
									}
								}

								@Override
								public void failed(Throwable exc, Object attachment) {
									System.out.println("write error");
								}

							});
				}

				public void failed(Throwable exc, Void attachment) {
					System.out.println("fail");
				}

			});
			Thread.sleep(10000);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}