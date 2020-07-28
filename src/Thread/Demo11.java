package Thread;

/**
 * @program: data-structure
 * @description: getId方法  作用获取当前线程的唯一标识
 * @author: wang hao
 * @create: 2020-05-14 16:17
 */
public class Demo11 {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "," + thread.getId());
    }
}
