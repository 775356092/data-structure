package LeetCode;

/**
 * @program: data-structure
 * @description: 搜索二维矩阵 II
 * @author: wang hao
 * @create: 2020-06-01 14:26
 */
public class _240 {
    /**
     * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * <p>
     * 每行的元素从左到右升序排列。
     * 每列的元素从上到下升序排列。
     */

    //选左上角，往右走和往下走都增大，不能选
    //
    //选右下角，往上走和往左走都减小，不能选
    //
    //选左下角，往右走增大，往上走减小，可选
    //
    //选右上角，往下走增大，往左走减小，可选

    //起点选择左下角
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (col < matrix[0].length && row >= 0) {
            if (target > matrix[row][col]) {
                col++;
            } else if (target < matrix[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}
