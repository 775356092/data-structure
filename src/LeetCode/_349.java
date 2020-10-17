package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @description: 两个数组的交集
 * @author: wang hao
 * @create: 2020-10-12 10:45
 */
public class _349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                set.remove(num);
                list.add(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
