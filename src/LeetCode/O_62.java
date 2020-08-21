package LeetCode;

import java.util.ArrayList;

/**
 * @program: data-structure
 * @description: 圆圈中最后剩下的数字
 * @author: wang hao
 * @create: 2020-05-21 11:25
 */
public class O_62 {
    public static int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = m % n - 1;
        if (i == -1) {
            i = n - 1;
        }
        n--;
        list.remove(i);
        while (n > 1) {
            i = (i + m - 1) % n;
            n--;
            list.remove(i);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        int i = lastRemaining(10, 17);
        System.out.println(i);
    }
}
