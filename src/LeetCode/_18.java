package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 四数之和
 * @author: wang hao
 * @create: 2020-09-07 15:09
 */
public class _18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        while (left < right && nums[right] == nums[--right]) ;
                    } else if (sum < target) {
                        while (left < right && nums[left] == nums[++left]) ;
                    } else {
                        res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[left], nums[right])));
                        while (left < right && nums[right] == nums[--right]) ;
                        while (left < right && nums[left] == nums[++left]) ;
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        List<List<Integer>> lists = fourSum(new int[]{1, -2, -5, -4, -3, 3, 3, 5}, -11);
        System.out.println(lists);
    }
}
