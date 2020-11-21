package LeetCode;

/**
 * @description: 多数元素
 * @author: wang hao
 * @create: 2020-11-16 10:48
 */
public class _169 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (res == nums[i])
                ++count;
            else if (--count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }
}
