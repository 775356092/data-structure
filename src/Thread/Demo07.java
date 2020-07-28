package Thread;

/**
 * @program: data-structure
 * @description: 共享数据
 * @author: wang hao
 * @create: 2020-05-14 16:07
 */
public class Demo07 {
    public static void main(String[] args) {
        Thread t = new Demo07Thread();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        Thread t5 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
//共享数据有概率出现不同线程使用相同的count的值，产生了『非线程安全问题』
class Demo07Thread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        count--;
        System.out.println(Thread.currentThread().getName() + ", count=" + count);
    }
}
