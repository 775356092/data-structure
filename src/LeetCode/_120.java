package LeetCode;

import java.util.List;

/**
 * @description: 三角形最小路径和
 * @author: wang hao
 * @create: 2020-07-14 09:44
 */
public class _120 {
    /**
     * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
     * <p>
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int size = triangle.get(len - 1).size();
        int[][] dp = new int[size][size];
        /**
         * dp[i][j]表示从三角形顶部走到(i,j)的最小路径，那么上一次位置的下标只可能在(i-1,j-1)或者是(i-1,j)
         * dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
         * 但是当(i,j)在最左侧时，即j==0时，上一次的位置只能是(i-1,j) --> dp[i][0] = dp[i-1][0] + triangle[i][0]
         * 当(i,j)在最右侧时，即i==j时，上一次的位置只能时(i-1,j-1) --> dp[i][i] = dp[i-1][i-1] + triangle[i][i]
         */
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                } else if (i == j) {
                    dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                }
            }
        }
        int res = dp[size - 1][0];
        for (int i = 0; i < size; i++) {
            res = Math.min(res, dp[size - 1][i]);
        }
        return res;
    }
}
