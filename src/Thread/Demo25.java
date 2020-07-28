package Thread;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-28 14:15
 */
public class Demo25 {
    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){}
            }
        });
        //启动线程
        threadA.start();
        //设置中断标志
        threadA.interrupt();
        //获取中断标志
        System.out.println("isInterrupted:"+threadA.isInterrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:"+threadA.interrupted());
        //获取中断标志并重置
        System.out.println("isInterrupted:"+Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted:"+threadA.isInterrupted());

        threadA.join();
        System.out.println("main thread over");
    }
}
