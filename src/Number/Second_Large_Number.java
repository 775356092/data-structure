package Number;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Second_Large_Number {
    public static int FindSecondLargestNum(int[] a) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            set.add(a[i]);
        }
        for (Integer i : set) {
            list.add(i);
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            if (i == 1) {
                return list.get(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = FindSecondLargestNum(new int[]{1, 4, 2, 4, 4, 7, 5, 10, 7, 7, 8, 8, 8, 9});
        System.out.println(i);
    }
}
