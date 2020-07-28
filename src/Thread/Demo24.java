package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 14:15
 */
public class Demo24 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("ThreadA begin sleep for 2000 seconds");
                    Thread.sleep(2000000);
                    System.out.println("ThreadA awaking");
                } catch (InterruptedException e) {
                    System.out.println("ThreadA is interrupted while sleeping");
                    return;
                }
                System.out.println("ThreadA leaving normally");
            }
        });
        //启动线程
        threadA.start();
        //确保子线程进入休眠状态
        Thread.sleep(1000);
        //打断子线程的休眠，让子线程从sleep函数返回
        System.out.println("main thread interrupt threadA");
        threadA.interrupt();

        //等待子线程执行完毕
        threadA.join();
        System.out.println("main thread over");
    }
}
