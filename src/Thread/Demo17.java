package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 11:29
 */
public class Demo17 {

    /**
     * 线程调用共享资源的wait方法时，会变成阻塞状态，并释放持有该共享对象的锁
     */


    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                try {
                    synchronized (resourceA){
                        System.out.println("threadA get resourceA lock");
                        synchronized (resourceB){
                            System.out.println("threadA get resourceB lock");
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourceA){
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock...");
                        synchronized (resourceB){
                            System.out.println("threadB get resourceB lock");
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //启动线程
        threadA.start();
        threadB.start();
        //等待两个线程结束
        threadA.join();
        threadB.join();
        System.out.println("main over");
    }
}
