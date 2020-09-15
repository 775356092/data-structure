package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description: 数的平方等于两数乘积的方法数
 * @author: wang hao
 * @create: 2020-09-11 16:02
 */
public class _1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        return helper(nums1, nums2) + helper(nums2, nums1);
    }

    public int helper(int[] nums1, int[] nums2) {
        int res = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                long temp = (long) nums1[i] * (long) nums1[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        for (int value : nums2) {
            long temp = (long) value * (long) value;
            if (map.containsKey(temp)) {
                res += map.get(temp);
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(numTriplets(new int[]{43024, 99908}, new int[]{1864}));
    }
}
