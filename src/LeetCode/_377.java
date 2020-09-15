package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 组合总和 IV
 * @author: wang hao
 * @create: 2020-09-09 11:26
 */
public class _377 {

    /**
     * 回溯法堆内存溢出：java.lang.OutOfMemoryError: Java heap space
     */

//    List<List<Integer>> res;
//
//    public int combinationSum4(int[] nums, int target) {
//        res = new ArrayList<>();
//        Arrays.sort(nums);
//        dfs(nums, target, new ArrayList<>());
//        return res.size();
//    }
//
//    public void dfs(int[] nums, int target, ArrayList<Integer> list) {
//        if (target == 0) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int num : nums) {
//            if (num > target) {
//                break;
//            }
//            list.add(num);
//            dfs(nums, target - num, list);
//            list.remove(list.size() - 1);
//        }
//    }

    @Test
    public void test() {
        System.out.println(combinationSum4(new int[]{4, 2, 1}, 32));
    }

    public int combinationSum4(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }

        int[] dp = new int[target + 1];
        // dp[0] 表示组成 0，一个数都不选就可以了，所以 dp[0] = 1
        dp[0] = 1;
        // dp[i] = dp[i - nums[0]] + dp[i - nums[1]] + ... + dp[i - nums[len - 1]]
        // 使用 dp 数组，dp[i] 代表组合数为 i 时使用 nums 中的数能组成的组合数的个数
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }

        }
        return dp[target];
    }

}
