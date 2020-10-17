package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 合并两个有序数组
 * @author: wang hao
 * @create: 2020-09-30 16:58
 */
public class _88 {

    //O(m)空间
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0, p2 = 0;
        int[] t = Arrays.copyOfRange(nums1, 0, m);
        int index = 0;
        while (p1 != m || p2 != n) {
            if (p1 < m && p2 < n) {
                if (t[p1] >= nums2[p2]) {
                    nums1[index] = nums2[p2];
                    p2++;
                } else {
                    nums1[index] = t[p1];
                    p1++;
                }
            } else if (p1 == m) {
                nums1[index] = nums2[p2];
                p2++;
            } else if (p2 == n) {
                nums1[index] = t[p1];
                p1++;
            }
            index++;
        }
    }

    //O(1)空间
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int index = m + n - 1;
        while (p1 != 0 || p2 != 0) {
            if (p1 > 0 && p2 > 0) {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[index] = nums1[p1];
                    p1 --;
                } else {

                }
            }
        }

    }

    @Test
    public void test() {
        //merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
        //merge(new int[]{2,0}, 1, new int[]{1}, 1);
        merge(new int[]{4, 0, 0, 0, 0, 0}, 1, new int[]{1, 2, 3, 5, 6}, 5);
    }
}
