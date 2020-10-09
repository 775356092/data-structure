package LeetCode;

/**
 * @description: 乘积小于K的子数组
 * @author: wang hao
 * @create: 2020-10-09 17:34
 */
public class _713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int res = 0, t = 1, l = 0;
        for (int i = 0; i < nums.length; i++) {
            t *= nums[i];
            while (t >= k) {
                t /= nums[l++];
            }
            res += i - l + 1;
        }
        return res;
    }
}
