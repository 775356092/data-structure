package LeetCode;

import org.junit.Test;

/**
 * @Description : 翻转矩阵后的得分
 * @Author : wang hao
 * @Date: 2020-12-07 22:47
 */
public class _861 {
    public int matrixScore(int[][] A) {
        int r = A.length;
        if (r == 0) return 0;
        int c = A[0].length;
        // 使第一列都为1
        for (int i = 0; i < r; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < c; j++) {
                    A[i][j] = (1 - A[i][j]);
                }
            }
        }
        // 翻转列
        for (int j = 1; j < c; j++) {
            int zeroCount = 0;
            for (int i = 0; i < r; i++) {
                if (A[i][j] == 0) zeroCount++;
            }
            if (zeroCount > (r - zeroCount)) {
                for (int i = 0; i < r; i++) {
                    A[i][j] = (1 - A[i][j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = c - 1; j >= 0; j--) {
                res += A[i][j] * Math.pow(2, c - j - 1);
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(matrixScore(new int[][]{{0, 0, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 0}}));
    }
}
