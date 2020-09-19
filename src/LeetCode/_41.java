package LeetCode;

import org.junit.Test;

import java.util.HashSet;

/**
 * @description: 缺失的第一个正数
 * @author: wang hao
 * @create: 2020-09-17 15:56
 */
public class _41 {

    /**
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     */

    /**
     * 空间复杂度不符合要求
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i < (int) 1e6; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 1放到下标0, 2放到下标1...
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //我们要找的数就在 [1, N + 1] 里，最后 N + 1 这个元素我们不用找。因为在前面的 N 个元素都找不到的情况下，我们才返回 N + 1；
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test() {
        System.out.println(firstMissingPositive(new int[]{3, 8, 7, 10, 1}));
    }
}
