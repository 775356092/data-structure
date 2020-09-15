package LeetCode;

import org.junit.Test;

/**
 * @description: 避免重复字母的最小删除成本
 * @author: wang hao
 * @create: 2020-09-11 16:11
 */
public class _1578 {

    public int minCost(String s, int[] cost) {
        int res = 0;
        char[] arr = s.toCharArray();
        int left = 0, right = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                right = i + 1;
                continue;
            } else if (left != right) {
                res += cal(cost, left, right);
            }
            left = right = i + 1;
        }
        if (left != right) {
            res += cal(cost, left, right);
        }
        return res;
    }

    public int cal(int[] cost, int left, int right) {
        int max = 0, count = 0;
        for (int i = left; i <= right; i++) {
            max = Math.max(cost[i], max);
            count += cost[i];
        }
        return count - max;
    }

    @Test
    public void test() {
        System.out.println(minCost("aabaa", new int[]{1, 2, 3, 4, 1}));
    }

}
