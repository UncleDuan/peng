package concurrent.threadpool.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by pengsel on 2019/3/20.
 * 线程如果在运行过程中发生异常也会提前结束；
 * 1.通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、
 * 限期等待或者无限期等待状态，那么就会抛出 InterruptedException，
 * 从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。
 * 2.如果一个线程的 run() 方法执行一个无限循环，并且没有执行 sleep()
 * 等会抛出 InterruptedException 的操作，那么调用线程的 interrupt()
 * 方法就无法使线程提前结束。但是调用 interrupt() 方法会设置线程的中断标记，
 * 此时调用 interrupted() 方法会返回 true。
 * 因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。
 *
 */
public class WhatsInterrupt {
    private static class MyThread1 extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class MyThread2 extends Thread {
        @Override
        public void run() {
            while (!interrupted()) {
                // ..
            }
            System.out.println("Thread end");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread thread1 = new MyThread1();
//        thread1.start();
//        thread1.interrupt();
//        System.out.println("Main run");

        Thread thread2 = new MyThread2();
        thread2.start();
        thread2.interrupt();
    }

    /**
     * 3.调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，
     * 但是如果调用的是 shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法。
     * 以下使用 Lambda 创建线程，相当于创建了一个匿名内部线程。
     */
    @Test
    public void TestExecutorInterrupt() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("Thread run");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();
        System.out.println("Main run");
    }


}
