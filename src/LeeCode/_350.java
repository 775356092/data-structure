package LeeCode;

import java.util.ArrayList;

/**
 * @description: 两个数组的交集 II
 * @author: wang hao
 * @create: 2020-07-13 08:49
 */
public class _350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums1.length <= nums2.length) {
            for (int a : nums1) {
                for (int b : nums2) {
                    if (a == b) {
                        res.add(a);
                        break;
                    }
                }
            }
        }
        if (nums1.length > nums2.length) {
            for (int a : nums2) {
                for (int b : nums1) {
                    if (a == b) {
                        res.add(a);
                        break;
                    }
                }
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
