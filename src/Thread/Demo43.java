package Thread;

import jdk.nashorn.internal.parser.JSONParser;
import sun.plugin.javascript.ocx.JSObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @description: concurrentHashMap
 * @author: wang hao
 * @create: 2020-08-17 14:25
 */
public class Demo43 {
    static ConcurrentHashMap<String,List<String>> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list1 = new ArrayList<>();
                list1.add("device1");
                list1.add("device2");
                map.put("topic1",list1);
                System.out.println(map);
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list1 = new ArrayList<>();
                list1.add("device11");
                list1.add("device22");
                map.put("topic1",list1);
                System.out.println(map);
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list1 = new ArrayList<>();
                list1.add("device111");
                list1.add("device222");
                map.put("topic2",list1);
                System.out.println(map);
            }
        });
        threadA.start();
        threadB.start();
        threadC.start();
    }
}
