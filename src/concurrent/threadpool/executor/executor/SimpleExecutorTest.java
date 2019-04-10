package threadpool.executor;

import threadpool.thread.MyRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * Created by pengsel on 2019/3/20.
 */
public class SimpleExecutorTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }
}
