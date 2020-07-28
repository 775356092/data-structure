package Thread;

/**
 * @program: data-structure
 * @description: currentThread方法  返回代码正在那个线程调用的详细信息
 * @author: wang hao
 * @create: 2020-05-14 16:10
 */
public class Demo08 {
    public static void main(String[] args) {
        Thread t = new Demo08Thread();
        t.start();
        System.out.println("main方法：" + Thread.currentThread().getName());
    }
}

class Demo08Thread extends Thread {
    public Demo08Thread() {
        System.out.println("构造方法：" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法" + Thread.currentThread().getName());
    }
}
