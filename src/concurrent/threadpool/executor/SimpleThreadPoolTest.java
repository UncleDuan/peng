package concurrent.threadpool.executor;

/**
 * Created by pengsel on 2019/3/12.
 */
public class SimpleThreadPoolTest {
    public static void main(String[] args) {
        SimpleThreadPool myThreadPool = new SimpleThreadPool(5);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"执行中");
            }
        };

        for (int i = 0; i < 20; i++) {
            myThreadPool.execute(task);
        }
    }
}
