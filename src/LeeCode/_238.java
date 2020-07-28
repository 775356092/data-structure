package LeeCode;

/**
 * @program: data-structure
 * @description: 除自身以外数组的乘积
 * @author: wang hao
 * @create: 2020-05-21 15:41
 */
public class _238 {
    /**
     * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
     * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
     */
    public int[] productExceptSelf(int[] nums) {
        //存放当前下标左侧的乘积
        int left[] = new int[nums.length];
        //存放当前下标右侧的乘积
        int right[] = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int j = nums.length - 2; j >= 0; j--) {
            right[j] = right[j + 1] * nums[j + 1];
        }

        int res[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
