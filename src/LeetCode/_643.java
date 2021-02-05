package LeetCode;

import org.junit.Test;

/**
 * @Author: wang hao
 * @Description: 子数组的最大平均数 I
 * @Date: 2021/2/5 1:40 下午
 */
public class _643 {
    public double findMaxAverage(int[] nums, int k) {
        double res;
        int left = 0, right = k;
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        res = sum / k;
        while (right < nums.length) {
            sum += nums[right];
            sum -= nums[left++];
            double avg = sum / k;
            res = Math.max(res, avg);
            right++;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
