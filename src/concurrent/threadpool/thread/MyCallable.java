package concurrent.threadpool.thread;

import java.util.concurrent.Callable;

/**
 * Created by pengsel on 2019/3/20.
 */
public class MyCallable implements Callable<Integer> {
    public Integer call() {
        System.out.println(Thread.currentThread().getName()+"Implement Callable，实现call方法，return in futuretask");
        return 123;
    }
}
