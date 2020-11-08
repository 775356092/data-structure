package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class _1365 {
    //1365. 有多少小于当前数字的数字
    //给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
    //换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
    //以数组形式返回答案。
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] t = Arrays.copyOf(nums, nums.length);
        int[] res = new int[nums.length];
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map1.put(nums[i], i - map.get(nums[i]));
            } else {
                map1.put(nums[i], i);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < t.length; i++) {
            res[i] = map1.get(nums[i]);
        }
        return res;
    }
}
