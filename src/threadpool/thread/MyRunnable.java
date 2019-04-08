package threadpool.thread;

/**
 * Created by pengsel on 2019/3/20.
 */
public class MyRunnable implements Runnable {
    public void run() {
        // ...
        System.out.println(Thread.currentThread().getName()+"-------Implments Runnable，实现run方法");
    }
}
