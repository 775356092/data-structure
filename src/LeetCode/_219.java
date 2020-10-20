package LeetCode;

import java.util.HashSet;

/**
 * @description: 存在重复元素 II
 * @author: wang hao
 * @create: 2020-10-16 17:25
 */
public class _219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

}
