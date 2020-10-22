package LeetCode;

import org.junit.Test;

/**
 * @description: 最大正方形
 * @author: wang hao
 * @create: 2020-10-22 13:58
 */
public class _221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        // 以martix[i][j]为右下角的最大正方形的边长
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i > 0 && j > 0) {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

    @Test
    public void test() {
        System.out.println(maximalSquare(new char[][]{{'1'}}));
        System.out.println(maximalSquare(new char[][]{{'0'}, {'1'}}));
    }
}
