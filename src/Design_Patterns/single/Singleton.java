package Design_Patterns.single;

/**
 * @program: data-structure
 * @description: 利用私有的内部工厂类（线程安全，内部类也可以换成内部接口，不过工厂类变量的作用域要改为public了。）
 * @author: wang hao
 * @create: 2020-05-14 15:32
 */
public class Singleton {
    public Singleton() {
        System.out.println("Singleton: " + System.nanoTime());
    }

    public static Singleton getInstance() {
        return SingletonFactory.singletonInstance;
    }

    private static class SingletonFactory {
        private static Singleton singletonInstance = new Singleton();
    }
}
