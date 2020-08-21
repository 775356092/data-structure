package LeetCode;

import java.util.HashMap;

/**
 * @program: data-structure
 * @description: 多数元素
 * @author: wang hao
 * @create: 2020-05-20 15:25
 */
public class _169 {
    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     */
    public int majorityElement(int[] nums) {
        //总是存在
        if (nums.length == 1 || nums.length == 2) {
            return nums[0];
        }
        int count = nums.length % 2 == 0 ? (nums.length / 2) : (nums.length / 2) + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int res = nums[0];
        for (Integer i : map.keySet()) {
            if (map.get(i) >= count) {
                res = i;
                break;
            }
        }
        return res;
    }
}
