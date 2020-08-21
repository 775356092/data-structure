package Thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @description: Timer
 * @author: wang hao
 * @create: 2020-08-18 11:02
 */
public class Demo47 {
    //定时器
    static Timer timer = new Timer();

    public static void main(String[] args) {
        //任务1
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("-----one Task----");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                throw new RuntimeException("error ");
            }
        }, 500);
        //任务2
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (;;){
                    System.out.println("-----two Task----");
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 1000);
    }
}
