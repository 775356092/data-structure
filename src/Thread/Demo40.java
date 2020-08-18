package Thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-08-17 14:25
 */
public class Demo40 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static void main(String[] args) throws InterruptedException{
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println(Thread.currentThread()+" step1");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+" step2");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+" step3");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread()+" step1");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+" step2");
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread()+" step3");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        executorService.shutdown();
    }
}
