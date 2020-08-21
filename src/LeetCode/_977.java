package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @program: data-structure
 * @description: 有序数组的平方
 * @author: wang hao
 * @create: 2020-05-18 12:51
 */
public class _977 {
    /**
     * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
     */
    public static int[] sortedSquares(int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add((A[i] * A[i]));
        }
        Collections.sort(list);
        int[] res = new int[A.length];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-7, -3, 2, 3, 11});
        System.out.println(Arrays.toString(ints));
    }
}
