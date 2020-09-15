package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 三数之和
 * @author: wang hao
 * @create: 2020-09-07 13:55
 */
public class _15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    while(left < right && nums[right] == nums[--right]);
                } else if (sum < 0) {
                    while(left < right && nums[left] == nums[++left]);
                } else {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    while(left < right && nums[right] == nums[--right]);
                    while(left < right && nums[left] == nums[++left]);
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
