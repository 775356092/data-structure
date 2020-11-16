package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 求众数 II
 * @author: wang hao
 * @create: 2020-11-16 10:56
 */
public class _229 {
    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = nums.length / 3;
        for (int t : nums) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        map.forEach((key, value) -> {
            if(value > num) res.add(key);
        });
        return res;
    }
}
