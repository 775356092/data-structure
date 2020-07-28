package LeeCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 数组拆分 I
 * @author: wang hao
 * @create: 2020-05-18 14:39
 */
public class _561 {
    /**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     */
    public static int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            res+=Math.min(nums[i],nums[i+1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = arrayPairSum(new int[]{1, 4, 3, 2,5,6});
        System.out.println(i);
    }
}
