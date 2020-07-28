package Thread;

/**
 * @program: data-structure
 * @description: 使用退出标志，使线程正常退出，也就是当run方法完成后线程终止
 * @author: wang hao
 * @create: 2020-05-14 16:19
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Demo12Thread t = new Demo12Thread();
        t.start();
        Thread.sleep(2000);
        t.stopThread();
    }
}

class Demo12Thread extends Thread {
    private boolean flag = true;

    @Override
    public void run() {
        try {
            while (flag) {
                System.out.println("time=" + System.currentTimeMillis());
                Thread.sleep(1000);
            }
            System.out.println("线程执行结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stopThread() {
        flag = false;
    }
}
