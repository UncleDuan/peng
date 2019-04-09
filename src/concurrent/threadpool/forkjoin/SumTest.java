package concurrent.threadpool.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

//���������
public class SumTest {
    
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //����ִ���̳߳�
    	ForkJoinPool pool = new ForkJoinPool();
    	//ForkJoinPool pool = new ForkJoinPool(4);
    	
    	//��������
        SumTask task = new SumTask(1, 10000000);
        
        //�ύ����
        ForkJoinTask<Long> result = pool.submit(task);
        
        //�ȴ����
        do {
			System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
			System.out.printf("Main: Paralelism: %d\n",pool.getParallelism());
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
        
        //������
        System.out.println(result.get().toString());
    }
}
