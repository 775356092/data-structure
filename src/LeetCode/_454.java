package LeetCode;

import java.util.HashMap;

/**
 * @description: 四数相加 II
 * @author: wang hao
 * @create: 2020-11-27 10:32
 */
public class _454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : A) {
            for (int j : B) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i : C) {
            for (int j : D) {
                int sum = - i - j;
                if (map.containsKey(sum)) {
                    res += map.get(sum);
                }
            }
        }
        return res;
    }
}
