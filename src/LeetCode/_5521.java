package LeetCode;

import org.junit.Test;

/**
 * @Description :
 * @Author : wang hao
 * @Date: 2020-09-20 11:34
 */
public class _5521 {
    public int maxProductPath(int[][] grid) {
        int t = 1000000007;
        int row = grid.length;
        int col = grid[0].length;
        long[][][] dp = new long[row][col][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
        }
        for (int i = 1; i < col; i++) {
            dp[0][i][0] = dp[0][i - 1][0] * grid[0][i];
            dp[0][i][1] = dp[0][i - 1][0] * grid[0][i];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (grid[i][j] == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else if (grid[i][j] < 0) {
                    dp[i][j][0] = Math.max(dp[i][j - 1][1] * grid[i][j], dp[i - 1][j][1] * grid[i][j]);
                    dp[i][j][1] = Math.min(dp[i][j - 1][0] * grid[i][j], dp[i - 1][j][0] * grid[i][j]);
                } else {
                    dp[i][j][0] = Math.min(dp[i][j - 1][0] * grid[i][j], dp[i - 1][j][0] * grid[i][j]);
                    dp[i][j][1] = Math.max(dp[i][j - 1][1] * grid[i][j], dp[i - 1][j][1] * grid[i][j]);
                }
            }
        }
        long res = dp[row - 1][col - 1][1];
        if (res >= 0) {
            return (int) res % t;
        }
        return -1;
    }

    @Test
    public void test() {
        //System.out.println(maxProductPath(new int[][]{{-1, -2, -3},
        //{-2, -3, -3}, {-3, -3, -2}}));
        System.out.println(maxProductPath(new int[][]{{1, -2, 1},
                {1, -2, 1}, {3, -4, 1}}));

    }
}
