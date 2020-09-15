package LeetCode;

import org.junit.Test;

/**
 * @description: 不同路径 II
 * @author: wang hao
 * @create: 2020-09-11 13:11
 */
public class _63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //左边界
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        //上边界
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    @Test
    public void test() {
        System.out.println(uniquePathsWithObstacles(new int[][]{{0, 1}}));
    }
}
