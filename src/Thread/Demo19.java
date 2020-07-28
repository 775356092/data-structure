package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 13:11
 */
public class Demo19 {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadA end");
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ThreadB end");
            }
        });
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("main thread end");
    }
}
