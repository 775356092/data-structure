package Thread;

/**
 * @program: data-structure
 * @description: 线程运行具有随机性
 * @author: wang hao
 * @create: 2020-05-14 15:48
 */
public class Demo03 {
    public static void main(String[] args) {
        Thread t = new Demo03Thread();
        t.start();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("运行main方法");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Demo03Thread extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("运行run方法");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
