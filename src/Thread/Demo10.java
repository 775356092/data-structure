package Thread;

/**
 * @program: data-structure
 * @description: sleep方法  作用是在指定的毫秒数内让当前『正在执行的线程』暂停执行
 * @author: wang hao
 * @create: 2020-05-14 16:15
 */
public class Demo10 {
    public static void main(String[] args) {
        Thread t = new Demo10Thread();
        System.out.println("开始于" + System.currentTimeMillis());
        t.start();
        System.out.println("结束于" + System.currentTimeMillis());
    }
}

class Demo10Thread extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("线程开始于" + System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("线程结束于" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
