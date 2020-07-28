package Thread;

/**
 * @program: data-structure
 * @description: 继承Thread类
 * @author: wang hao
 * @create: 2020-05-14 15:44
 */
public class Demo02 {
    public static void main(String[] args) {
        Thread t = new Demo02Thread();
        t.start();  // 启动线程
        System.out.println("运行了main方法");
    }
}

class Demo02Thread extends Thread {
    @Override
    public void run() {
        System.out.println("运行了run方法");
    }
}
