package concurrent.threadpool.thread.product;

import java.util.Random;

/**
 * ������
 */
class Producer implements Runnable {
	private Storage storage;

	public Producer(Storage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		int i = 0;
		Random r = new Random();
		while(i<10)
		{
			i++;
			Product product = new Product(i, "�绰" + r.nextInt(100));
			storage.push(product);
		}		
	}
}
