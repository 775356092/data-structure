package Thread;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @description: SimpleDateFormat
 * @author: wang hao
 * @create: 2020-08-18 10:28
 */
public class Demo46 {
    static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(threadLocal.get().parse("2020-08-18 10:30:00"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        threadLocal.remove();
                    }
                }
            });
            thread.start();
        }
    }
}
