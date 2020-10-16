package LeetCode;

import java.util.Arrays;

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
        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = A[i] * A[i];
        }
        Arrays.sort(res);
        return res;
    }

}
