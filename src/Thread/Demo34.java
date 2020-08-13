package Thread;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.LockSupport;

/**
 * @description: unsafe
 * @author: wang hao
 * @create: 2020-07-29 15:51
 */
public class Demo34 {

    private static volatile CopyOnWriteArrayList arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1, "baba");
                arrayList.remove(2);
                arrayList.remove(3);
            }
        });
        threadA.start();
        Iterator iterator = arrayList.iterator();
        threadA.join();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    static class test {
        public static void main(String[] args) {
            System.out.println("begin park");
            LockSupport.park();
            System.out.println("end park");
        }
    }

}
