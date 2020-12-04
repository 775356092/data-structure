package LeetCode;

/**
 * @description: 最小移动次数使元素相等
 * @author: wang hao
 * @create: 2020-11-27 10:53
 */
public class _453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int num : nums) {
            min = Math.min(num, min);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
