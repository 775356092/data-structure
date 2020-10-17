package LeetCode;

import org.junit.Test;

/**
 * @description: 搜索二维矩阵
 * @author: wang hao
 * @create: 2020-10-12 15:52
 */
public class _74 {
    // 暴力
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // 二分
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int i = mid / col;
            int j = mid % col;
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        System.out.println(searchMatrix2(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13));
    }

}
