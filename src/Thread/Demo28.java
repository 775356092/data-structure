package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 14:15
 */
public class Demo28 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){}
            }
        });
        //守护线程
        //threadA.setDaemon(true);
        threadA.start();
        System.out.println("main thread end");
    }
}
