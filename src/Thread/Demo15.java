package Thread;

/**
 * @program: data-structure
 * @description: 使用interrupt方法中断线程
 * @author: wang hao
 * @create: 2020-05-14 16:35
 */
public class Demo15 {
    public static void main(String[] args) {
        Thread t = new Demo15Thread();
        t.start();
        t.interrupt();
        System.out.println("是否停止1？" + t.isInterrupted());
        System.out.println("是否停止2？" + Thread.interrupted());
    }
}

class Demo15Thread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println("i=" + i);
        }
    }
}
