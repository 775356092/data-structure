package Design_Patterns.single;

/**
 * @program: data-structure
 * @description: 饿汉模式（线程安全）
 * @author: wang hao
 * @create: 2020-05-14 15:23
 */
public class Single2 {
    private static Single2 instance = new Single2();

    public Single2() {
        System.out.println("Single2: " + System.nanoTime());
    }

    public static Single2 getInstance() {
        return instance;
    }
}
