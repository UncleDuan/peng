package threadpool.thread.product;
/**
 * ����������������������
 * �����߲��ϵ����ֿ��д�Ų�Ʒ�������ߴӲֿ������Ѳ�Ʒ��
 * ���������ߺ������߶����������ɸ���
 * �ֿ�����������ޣ�����ʱ���ܴ�ţ����ʱ����ȡ��Ʒ ��
 */

public class ProductTest {
	public static void main(String[] args) throws InterruptedException {
		Storage storage = new Storage();
		
		Thread consumer1 = new Thread(new Consumer(storage));
		consumer1.setName("������1");
		Thread consumer2 = new Thread(new Consumer(storage));
		consumer2.setName("������2");
		Thread producer1 = new Thread(new Producer(storage));
		producer1.setName("������1");
		Thread producer2 = new Thread(new Producer(storage));
		producer2.setName("������2");
		
		producer1.start();
		producer2.start();
		Thread.sleep(1000);		
		consumer1.start();
		consumer2.start();		
	}
}








