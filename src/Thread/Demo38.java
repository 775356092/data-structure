package Thread;

import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-07-31 10:03
 */
public class Demo38 {

    public void testPark(){
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        Demo38 demo37 = new Demo38();
        demo37.testPark();
    }
}
