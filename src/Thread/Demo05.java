package Thread;

/**
 * @program: data-structure
 * @description: 实现Runnable接口
 * @author: wang hao
 * @create: 2020-05-14 15:53
 */
public class Demo05 {
    public static void main(String[] args) {
        Runnable r = new Demo05Thread();
        Thread t = new Thread(r);
        t.start();
        System.out.println("运行了main方法");
    }
}

class Demo05Thread implements Runnable {
    @Override
    public void run() {
        System.out.println("运行了run方法");
    }
}
