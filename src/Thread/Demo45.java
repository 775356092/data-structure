package Thread;

import java.text.SimpleDateFormat;

/**
 * @description: SimpleDateFormat
 * @author: wang hao
 * @create: 2020-08-18 10:28
 */
public class Demo45 {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        synchronized (simpleDateFormat){
                            System.out.println(simpleDateFormat.parse("2020-08-18 10:30:00"));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }
}
