package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 最接近的三数之和
 * @author: wang hao
 * @create: 2020-09-07 14:44
 */
public class _16 {
    public int threeSumClosest(int[] nums, int target) {
        int res = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int sub = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) < sub) {
                    sub = Math.abs(sum - target);
                    res = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(threeSumClosest(new int[]{0, 2, 1, -3}, 1));
    }
}
