package threadpool.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by pengsel on 2019/3/20.
 */
public class WaysToUseThread {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1.实现Runnable接口；
        MyRunnable instance = new MyRunnable();
        Thread thread1 = new Thread(instance);
        thread1.start();

        //2.实现Callable接口
        MyCallable mc = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<Integer>(mc);
        Thread thread2 = new Thread(ft);
        thread2.start();
        System.out.println(ft.get());

        //3.继承Thread类
        MyThread mt = new MyThread();
        mt.start();
    }

}


