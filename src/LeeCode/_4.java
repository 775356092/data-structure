package LeeCode;

/**
 * @program: data-structure
 * @description: 寻找两个有序数组的中位数
 * @author: wang hao
 * @create: 2020-05-24 15:36
 */
public class _4 {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        //num1，num2分割线左边个数之和
        int total = nums1.length + (nums2.length - nums1.length + 1) / 2;
        //nums1[i]>=nums2[j-1] nums2[j]>=nums1[i-1]
        int left = 0;
        int right = nums1.length;
        while (left < right) {
            int i = left + (right - left) / 2; //nums1分割线左边的个数
            int j = total - i; // nums2分割线左边的个数
            if (nums1[i - 1] < nums2[j]) {
                right = i-1;
            }else {
                left = i;
            }
        }
        return 0;
    }
}
