package Design_Patterns.single;

/**
 * @program: data-structure
 * @description: 懒汉模式（如果方法没有synchronized，则线程不安全）
 * @author: wang hao
 * @create: 2020-05-14 15:25
 */
public class Single3 {
    private static Single3 instance = null;

    public Single3() {
        System.out.println("Single3: " + System.nanoTime());
    }

    public static synchronized Single3 getInstance() {
        if (instance == null) {
            instance = new Single3();
        }
        return instance;
    }
}
