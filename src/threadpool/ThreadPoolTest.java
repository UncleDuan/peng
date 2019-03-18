package threadpool;

/**
 * Created by pengsel on 2019/3/13.
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    public static void main(String[] args){

        //创建固定大小的线程池，这里只能完成3个任务
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        //创建缓存线程池，根据任务来自动创建线程的数量，可以完成创建的所有任务
        //ExecutorService threadPool = Executors.newCachedThreadPool();

        //创建单一线程池（始终保持线程池中有一个线程存活。当唯一线程死去，会创建新的继任者、
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for(int i=1;i<=10;i++){
            //内部类不能访问外部类的局部变量，所以i要定义为final，又由于i++.
            //所以在循环内部定义一个变量接收i
            final int task = i;
            threadPool.execute(new Runnable() {

                @Override
                public void run() {
                    for(int j=1;j<=10;j++){
                        System.out.println(Thread.currentThread().getName()
                                +" is looping of "+ j+"  for task of " +task);
                    }

                }
            });
        }
        //验证10个任务都提交给了线程池
        System.out.println("all of 10 tasks have committed! ");
        //threadPool.shutdown();        //等任务完成后，杀死线程、
        //threadPool.shutdownNow();     //立即停止线程

        //用线程池启动定时器

        Executors.newScheduledThreadPool(3).schedule(
                new Runnable() {  //任务
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getName()+"bombing!");
                    }
                },
                5,  //5秒以后执行
                TimeUnit.SECONDS);  //单位

        //在某个时间执行一次后，再指定后续的执行间隔时间
        Executors.newScheduledThreadPool(3).scheduleAtFixedRate(new Runnable()
        {

              @Override
              public void run() {
                     System.out.println(Thread.currentThread().getName()+"bombing!");
                     }
        },
                10,   //第一次在10秒时爆炸
              3,          //以后每隔3秒爆炸一次。
              TimeUnit.SECONDS);

    }
}
