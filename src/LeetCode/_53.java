package LeetCode;

/**
 * @program: data-structure
 * @description: 最大子序和
 * @author: wang hao
 * @create: 2020-05-21 12:35
 */
public class _53 {
    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     */

    //前缀和 presum[i] = max{presum[i-1]+nums[i],nums[i]}
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int preSum[] = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = Math.max(preSum[i - 1] + nums[i], nums[i]);
            res = Math.max(res, preSum[i]);
        }
        return res;
    }
}
