package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 14:15
 */
public class Demo27 {
    /**
     * 死锁
     */
    private static Object resourceA = new Object();
    private static Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println(Thread.currentThread()+" get resourceA");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" waiting get resourceB");
                    synchronized (resourceB){
                        System.out.println(Thread.currentThread()+" get resourceB");
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceB){
                    System.out.println(Thread.currentThread()+" get resourceB");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+" waiting get resourceA");
                    synchronized (resourceA){
                        System.out.println(Thread.currentThread()+" get resourceA");
                    }
                }
            }
        });
        threadA.start();
        threadB.start();
    }
}
