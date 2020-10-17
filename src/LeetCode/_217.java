package LeetCode;

import java.util.HashSet;

/**
 * @description: 存在重复元素
 * @author: wang hao
 * @create: 2020-10-16 15:32
 */
public class _217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
