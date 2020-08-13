package Thread;

/**
 * @description: unsafe
 * @author: wang hao
 * @create: 2020-07-29 15:51
 */
public class Demo33 {

    /**
     * 被volatile关键字修饰的共享变量在转换成汇编语言时，会加上一个以lock为前缀的指令，当CPU发现这个指令时，立即做两件事：
     * 1.将当前内核高速缓存行的数据立刻回写到内存；
     * 2.使在其他内核里缓存了该内存地址的数据无效。
     * <p>
     * volatile是一种非锁机制，这种机制可以避免锁机制引起的线程上下文切换和调度问题。因此，volatile的执行成本比synchronized更低。
     * <p>
     * 使用volatile关键字，可以保证变量在线程之间的可见性，但是却不能保证原子操作
     */

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws Exception{
        final Demo33 test = new Demo33();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 1000; j++){
                    test.increase();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 1000; j++){
                    test.increase();
                }
            }
        });
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println(test.inc);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }


}
