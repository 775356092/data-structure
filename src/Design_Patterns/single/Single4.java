package Design_Patterns.single;

/**
 * @program: data-structure
 * @description: 懒汉模式改良版（线程安全，使用了double-check，即check-加锁-check，目的是为了减少同步开销）
 * @author: wang hao
 * @create: 2020-05-14 15:28
 */
public class Single4 {
    private volatile static Single4 instance = null;

    public Single4() {
        System.out.println("Single4: " + System.nanoTime());
    }

    public static Single4 getInstance() {
        if (instance == null) {
            synchronized (Single4.class) {
                if (instance == null) {
                    instance = new Single4();
                }
            }
        }
        return instance;
    }
}
