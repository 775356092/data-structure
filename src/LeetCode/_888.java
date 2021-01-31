package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description : 公平的糖果交换
 * @Author : wang hao
 * @Date: 2021-02-01 01:30
 */
public class _888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = Arrays.stream(A).sum();
        int sumB = Arrays.stream(B).sum();
        int t = (sumA - sumB) / 2;
        HashSet<Integer> set = new HashSet<>();
        for (int x : A) {
            set.add(x);
        }
        int[] res = new int[2];
        for (int y : B) {
            int x = y + t;
            if (set.contains(x)) {
                res[0] = x;
                res[1] = y;
            }
        }
        return res;
    }
}
