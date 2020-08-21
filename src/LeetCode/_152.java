package LeetCode;

import java.util.HashSet;

/**
 * @program: data-structure
 * @description: 乘积最大的子数组
 * @author: wang hao
 * @create: 2020-05-18 08:52
 */
public class _152 {
    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     */

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = 0;
        //tle
        /*for (; left < nums.length; left++) {
            for (int j = left; j < nums.length; j++) {
                int temp = 1;
                for (int i = left; i <= j; i++) {
                    temp *= nums[i];
                }
                if (temp >= res) {
                    res = temp;
                }
            }
        }*/
        //dp
        //Fmax(i) = Max(Fmax(i-1)*ai,Fmin(i-1)*ai,ai);
        //Fmin(i) = Min(Fmax(i-1)*ai,Fmin(i-1)*ai,ai);
        int Fmax[] = new int[nums.length];
        int Fmin[] = new int[nums.length];
        Fmax[0] = nums[0];
        Fmin[0] = nums[0];
        res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            Fmax[i] = Math.max(Fmax[i - 1] * nums[i], Math.max(Fmin[i - 1] * nums[i], nums[i]));
            Fmin[i] = Math.min(Fmin[i - 1] * nums[i], Math.min(Fmax[i - 1] * nums[i], nums[i]));
        }
        HashSet<Integer> set = new HashSet<>();

        return res;
    }

    public static void main(String[] args) {
        int i = maxProduct(new int[]{-2});
        System.out.println(i);
    }

}
