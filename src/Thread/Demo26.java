package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 14:15
 */
public class Demo26 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                //调用interrupted()方法后中断标志被清除了
                while (!Thread.currentThread().interrupted()) {

                }
                System.out.println("threadA isInterrupted:" + Thread.currentThread().isInterrupted());
            }
        });
        //启动线程
        threadA.start();
        //设置中断标志
        threadA.interrupt();

        threadA.join();
        System.out.println("main thread over");
    }
}
