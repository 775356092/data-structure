package Map;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Merge {
    // 合并

    public static void merge(TreeMap m) {
        Set set = m.keySet();
        for (Object o:set){
            System.out.println(o+" "+m.get(o));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            int key = Integer.parseInt(s1[0]);
            int value = Integer.parseInt(s1[1]);
            if (m.containsKey(key)) {
                int temp = m.get(key);
                m.replace(key, temp + value);
            } else {
                m.put(key, value);
            }
        }
        merge(m);
    }
}
