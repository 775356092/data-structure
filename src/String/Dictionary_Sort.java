package String;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Dictionary_Sort {
    // 给定n个字符串，请对n个字符串按照字典序排列。 使用TreeSet要注意重复的情况

    private static void m(TreeMap s) {
        Set set = s.keySet();
        for (Object o : set) {
            for (int i = 0; i < (int) s.get(o); i++) {
                System.out.println(o);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<Object, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            if (map.containsKey(s)) {
                int value = map.get(s) + 1;
                map.replace(s, value++);
            } else {
                map.put(s, 1);
            }
        }
        m(map);
    }

}
