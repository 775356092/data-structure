package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 13:11
 */
public class Demo20 {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("ThreadA begin");
                for (; ; ) {
                }
            }
        });
        //主线程
        final Thread mainThread = Thread.currentThread();
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });
        threadA.start();
        threadB.start();

        try {
            threadA.join();
        } catch (InterruptedException e) {
            System.out.println("main thread end:" + e);
        }
    }
}
