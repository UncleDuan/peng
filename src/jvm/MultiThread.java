package jvm;

/**
 * Created by ionolab-DP on 2018/12/29.
 */
public class MultiThread {
    public static void main(String[] args) {

        new Thread(new Thread1()).start();
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        new Thread(new Thread2()).start();


    }
    private static class Thread1 implements Runnable{

        @Override
        public void run() {
            synchronized (MultiThread.class){
                System.out.println("Enter thread1");
                System.out.println("Thread1 is waiting");
                try {
                    MultiThread.class.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("Thread1 is going on");
                System.out.println("Thread1 is being over");
            }
        }
    }

    private static class Thread2 implements Runnable{

        @Override
        public void run() {

            synchronized (MultiThread.class){
                System.out.println("Enter thread2");
                System.out.println("Thread2 notify other thread can release wait status");

                MultiThread.class.notify();

                System.out.println("Thread2 is sleeping ten millisecond");
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println("Thread2 is going on");
                System.out.println("Thread2 is being over");
            }
        }
    }
}
