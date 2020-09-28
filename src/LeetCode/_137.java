package LeetCode;

import java.util.HashMap;

/**
 * @description: 只出现一次的数字 II
 * @author: wang hao
 * @create: 2020-09-28 16:14
 */
public class _137 {
    //hash表
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}
