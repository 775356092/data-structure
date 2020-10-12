package LeetCode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description: 矩阵置零
 * @author: wang hao
 * @create: 2020-10-12 15:09
 */
public class _73 {
    public void setZeroes(int[][] matrix) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }
        for (int[] arr : list) {
            int i = arr[0], j = arr[1];
            for (int m = 0; m < matrix.length; m++) {
                matrix[m][j] = 0;
            }
            for (int n = 0; n < matrix[0].length; n++) {
                matrix[i][n] = 0;
            }
        }
    }

    @Test
    public void test() {
        setZeroes(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}});
    }

}
