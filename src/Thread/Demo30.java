package Thread;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description: unsafe
 * @author: wang hao
 * @create: 2020-07-29 15:51
 */
public class Demo30 {
    //获取Unsafe实例
    static final Unsafe unsafe;
    //记录变量state在类Demo30中的偏移量
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            //获取state变量在类Demo30中的偏移量
            stateOffset = unsafe.objectFieldOffset(Demo30.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        Demo30 demo30 = new Demo30();
        boolean b = unsafe.compareAndSwapInt(demo30, stateOffset, 0, 1);
        System.out.println(b);
    }
}
