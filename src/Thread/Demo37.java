package Thread;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-31 10:03
 */
public class Demo37 {
    public void testPark(){
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        Demo37 demo37 = new Demo37();
        demo37.testPark();
    }
}
