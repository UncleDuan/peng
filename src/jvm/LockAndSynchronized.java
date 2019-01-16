package jvm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ionolab-DP on 2019/1/1.
 */
public class LockAndSynchronized {
    private int j;
    private Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        LockAndSynchronized lockAndSynchronized=new LockAndSynchronized();
        for (int i=0;i<2;i++){
            new Thread(lockAndSynchronized.new Adder()).start();
            new Thread(lockAndSynchronized.new Subtractor()).start();
        }
    }

    private class Subtractor implements Runnable{

        @Override
        public void run() {
            while (true){
                while (true){
                    synchronized (LockAndSynchronized.this){
                        System.out.println("j--"+j--);
                    }
//                lock.lock();
//                try {
//                    System.out.println("j--"+j--);
//                }finally {
//                    lock.unlock();
                }
            }
        }

    }

    private class Adder implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (LockAndSynchronized.this){
                    System.out.println("j++"+j++);
                }
//                lock.lock();
//                try {
//                    System.out.println("j++"+j++);
//                }finally {
//                    lock.unlock();
            }
        }
    }
}
