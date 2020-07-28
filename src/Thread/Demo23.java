package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 14:15
 */
public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread()+" hello");
                }
            }
        });
        threadA.start();
        Thread.sleep(1);
        System.out.println("main thread interrupt threadA");
        threadA.interrupt();

        //等待子线程执行完毕
        threadA.join();
        System.out.println("main thread over");
    }
}
