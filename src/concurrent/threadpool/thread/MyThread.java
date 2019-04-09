package concurrent.threadpool.thread;

/**
 * Created by pengsel on 2019/3/20.
 */
public class MyThread extends Thread {
    public void run() {
        // ...
        System.out.println(Thread.currentThread().getName()+"Extends Thread，实现run方法");
    }
}
