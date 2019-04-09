package concurrent.threadpool.thread;

/**
 * Created by pengsel on 2019/3/20.
 * 守护线程是程序运行时后台提供服务的线程，不属于程序中不可或缺的部分；
 * 1.所有非守护线程结束时，程序将终止，同时会杀死所有守护线程；
 * 2.main()属于非守护线程；
 * 3.可以使用setDaemon()方法将一个线程设置成守护线程。
 */
public class WhatsDeamon {
    //todo IllegalMonitorStateException

    static class WaitThread implements Runnable{

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+":I am waiting");
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("WaitThread over");
        }
    }

    static class NotifyThread implements Runnable{

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+":I will sleep 1s and then notify a thread");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.notifyAll();
            System.out.println("NotifyThread over");
        }
    }

    public static class DeamonThread implements Runnable{

        public void run() {
            System.out.println("A DeamonThread");
            System.out.println("over");
        }
    }
    public static void main(String[] args) {
        System.out.println("main线程："+Thread.currentThread().getName());
        Thread threadDeamon=new Thread(new DeamonThread());
        threadDeamon.setDaemon(true);
        Thread thread1 = new Thread(new WaitThread());
        thread1.start();
        Thread thread2=new Thread(new NotifyThread());
        thread2.start();
        System.out.println("main线程："+Thread.currentThread().getName()+"over");
    }
}
