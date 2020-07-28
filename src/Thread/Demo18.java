package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 13:11
 */
public class Demo18 {
    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadA get resourceA lock");
                    try {
                        System.out.println("ThreadA begin wait");
                        resourceA.wait();
                        System.out.println("ThreadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    System.out.println("ThreadB get resourceA lock");
                    try {
                        System.out.println("ThreadB begin wait");
                        resourceA.wait();
                        System.out.println("ThreadB end wait");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA){
                    //resourceA.notify();
                    resourceA.notifyAll();
                }
            }
        });
        threadA.start();
        threadB.start();
        Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main thread end");
    }
}
