package LeetCode;

import java.util.Random;

/**
 * @program: data-structure
 * @description: 寻找重复数
 * @author: wang hao
 * @create: 2020-05-26 10:46
 */
public class _287 {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     */

    //二分查找 时间复杂度O(nlogn)
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int cnt = 0;
            for (int n : nums) {
                if (n <= mid) {
                    cnt++;
                }
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    //蒙特卡罗看运气法
    public static int findDuplicates(int[] nums) {
        while (true){
            int a = new Random().nextInt(nums.length);
            int b = new Random().nextInt(nums.length);
            if(a==b){
                continue;
            }
            if(nums[a]==nums[b]){
                return nums[a];
            }
        }
    }

    public static void main(String[] args) {
        int duplicates = findDuplicates(new int[]{1, 2, 3, 4, 5, 2});
        System.out.println(duplicates);
    }
}
