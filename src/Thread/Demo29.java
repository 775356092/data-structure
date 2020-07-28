package Thread;

/**
 * @description: ThreadLocalTest
 * @author: wang hao
 * @create: 2020-07-28 14:15
 */
public class Demo29 {
    static ThreadLocal<String> localVariable = new ThreadLocal<>() ;
    static void print(String str){
        System.out.println(str+":"+localVariable.get());
        //localVariable.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadA local variable");
                print("threadA");
                System.out.println("threadA remove after"+":"+localVariable.get());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                localVariable.set("threadB local variable");
                print("threadB");
                System.out.println("threadB remove after"+":"+localVariable.get());
            }
        });
        threadA.start();
        threadB.start();
    }
}
