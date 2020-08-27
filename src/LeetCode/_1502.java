package LeetCode;

import java.util.Arrays;

/**
 * @description: 判断是否能成为等差数列
 * @author: wang hao
 * @create: 2020-08-27 17:30
 */
public class _1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            int pre = arr[i];
            int next = arr[i + 1];
            if (next - pre != diff) {
                return false;
            }
        }
        return true;
    }
}
