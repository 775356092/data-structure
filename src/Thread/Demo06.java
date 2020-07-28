package Thread;

/**
 * @program: data-structure
 * @description: 不共享数据
 * @author: wang hao
 * @create: 2020-05-14 15:59
 */
public class Demo06 {
    public static void main(String[] args) {
        Thread t1 = new Demo06Thread();
        Thread t2 = new Demo06Thread();
        Thread t3 = new Demo06Thread();
        t1.start();
        t2.start();
        t3.start();
    }
}

class Demo06Thread extends Thread {
    private int count = 5;

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println(Thread.currentThread().getName() + ": count=" + count);
        }
    }
}
