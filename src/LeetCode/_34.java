package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: wang hao
 * @create: 2020-05-22 13:17
 */
public class _34 {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     */
    //二分查找
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums.length == 0) {
            return res;
        }
        int left = 0;
        int right = nums.length - 1;
        if (left == right) {
            if (target == nums[0]) {
                return new int[]{0, 0};
            }
            return res;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return res;
        }
        res[0] = left;
        left = 0;
        right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        res[1] = left - 1;
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(searchRange(new int[]{2,2}, 2)));
    }
}
