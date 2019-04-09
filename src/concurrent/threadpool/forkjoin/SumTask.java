package concurrent.threadpool.forkjoin;

import java.util.concurrent.RecursiveTask;

//���������
public class SumTask extends RecursiveTask<Long> {
	
	private int start;
	private int end;

	public SumTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public static final int threadhold = 5;

	@Override
	protected Long compute() {
		Long sum = 0L;
		
		// ��������㹻С, ��ֱ��ִ��
		boolean canCompute = (end - start) <= threadhold;
		if (canCompute) {
			for (int i = start; i <= end; i++) {
				sum = sum + i;				
			}
		} else {
			// ���������ֵ, ����Ϊ2������
			int middle = (start + end) / 2;
			SumTask subTask1 = new SumTask(start, middle);
			SumTask subTask2 = new SumTask(middle + 1, end);

			invokeAll(subTask1, subTask2);

			Long sum1 = subTask1.join();
			Long sum2 = subTask2.join();

			// ����ϲ�
			sum = sum1 + sum2;
		}
		return sum;
	}
}
