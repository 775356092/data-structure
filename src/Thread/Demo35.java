package Thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-31 09:32
 */
public class Demo35 {
    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                LockSupport.park();
                System.out.println("child thread unpark!");
            }
        });
        threadA.start();

        Thread.sleep(1000);
        System.out.println("main thread begin park");
        LockSupport.unpark(threadA);
    }

}
