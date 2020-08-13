package Thread;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @description: unsafe
 * @author: wang hao
 * @create: 2020-07-29 15:51
 */
public class Demo32 {
    //创建Long型原子计数器
    private static AtomicLong atomicLong = new AtomicLong();
    //创建数据源
    private static Integer[] arrayA = new Integer[]{0, 1, 2, 3, 0, 5, 6, 0, 56, 0};
    private static Integer[] arrayB = new Integer[]{10, 1, 2, 3, 0, 5, 6, 0, 56, 0};

    public static void main(String[] args) throws Exception {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayA.length;
                for (int i = 0; i < size; i++) {
                    if (arrayA[i] == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                int size = arrayB.length;
                for (int i = 0; i < size; i++) {
                    if (arrayB[i] == 0) {
                        atomicLong.incrementAndGet();
                    }
                }
            }
        });
        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();
        System.out.println("count 0:"+atomicLong.get());
    }
}
