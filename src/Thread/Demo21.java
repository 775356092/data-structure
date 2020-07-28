package Thread;

import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 13:11
 */
public class Demo21 {

    /**
     * Thread sleep的时候不会释放锁
     */

    //创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("ThreadA is in sleep");
                    Thread.sleep(10000);
                    System.out.println("ThreadA is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("ThreadB is in sleep");
                    Thread.sleep(10000);
                    System.out.println("ThreadB is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        });
        threadA.start();
        threadB.start();

        System.out.println("main thread end");
    }
}
