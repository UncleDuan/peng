package com.alibaba;

public class ThreadSharedVariable {
    public static int num=0;

    public static Object lock=new Object();
    public static void main(String[] args) {
        Worker worker1=new Worker(true);
        Worker worker2=new Worker(false);
        Thread A=new Thread(worker1);
        Thread B=new Thread(worker2);
        A.start();
        B.start();
    }

    static class Worker implements Runnable{

        private boolean printOdd;
        public Worker(boolean printOdd){
            this.printOdd=printOdd;
        }
        @Override
        public void run() {
            while (num<=100) {
                synchronized (lock) {
                    if (printOdd) {
                        if (num%2==1) {
                            System.out.println(Thread.currentThread().getName() + ":    " + num);
                            num++;
                        }
                    }else {
                        if (num%2==0) {
                            System.out.println(Thread.currentThread().getName() + ":    " + num);
                            num++;
                        }
                    }
                }
            }
        }
    }
}
