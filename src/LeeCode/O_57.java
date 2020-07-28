package LeeCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 和为s的两个数字
 * @author: wang hao
 * @create: 2020-05-20 15:54
 */
public class O_57 {
    public static int[] twoSum(int[] nums, int target) {
        int res[] = new int[2];
        int l = 0;
        int r = nums.length - 1;
        while (r >= 0 && l < nums.length && nums[l] + nums[r] != target) {
            if (nums[l] + nums[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        if (l < nums.length && r >= 0) {
            res[0] = nums[l];
            res[1] = nums[r];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 13);
        System.out.println(Arrays.toString(ints));
    }
}
