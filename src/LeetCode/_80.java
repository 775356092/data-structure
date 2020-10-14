package LeetCode;

import org.junit.Test;

/**
 * @description: 删除排序数组中的重复项 II
 * @author: wang hao
 * @create: 2020-10-14 09:55
 */
public class _80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n != nums[i - 2]) {
                nums[i] = n;
                i++;
            }
        }
        return i;
    }

    @Test
    public void test() {
        removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6});
    }
}
