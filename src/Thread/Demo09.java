package Thread;

/**
 * @program: data-structure
 * @description: isAlive  是判断当前的线程是否处于活动状态
 * @author: wang hao
 * @create: 2020-05-14 16:13
 */
public class Demo09 {
    public static void main(String[] args) {
        Thread t = new Demo09Thread();
        System.out.println("准备开始启动线程：" + t.isAlive());
        t.start();  // 启动线程
        System.out.println("启动线程后：" + t.isAlive());
    }
}

class Demo09Thread extends Thread {
    @Override
    public void run() {
        System.out.println("run方法运行状态：" + this.isAlive());
    }
}
