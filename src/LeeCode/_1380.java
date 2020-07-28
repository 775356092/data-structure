package LeeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure
 * @description: 矩阵中的幸运数
 * @author: wang hao
 * @create: 2020-05-18 13:15
 */
public class _1380 {
    /**
     * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
     * <p>
     * 幸运数是指矩阵中满足同时下列两个条件的元素：
     * <p>
     * 在同一行的所有元素中最小
     * 在同一列的所有元素中最大
     */
    public static List<Integer> luckyNumbers(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int cols = matrix[0].length;
        int rows = matrix.length;
        for (int i = 0; i < rows; i++) {
            int min = matrix[i][0];
            int row = i;
            int col = 0;
            //遍历列
            for (int j = 0; j < cols; j++) {
                if (min > matrix[i][j]) {
                    col = j;
                    min = matrix[i][j];
                }
            }
            boolean flag = false;
            //遍历行
            for (int k = 0; k < rows; k++) {
                if (matrix[k][col] > min) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                list.add(matrix[row][col]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> integers = luckyNumbers(new int[][]{{3, 7, 8}, {9, 11, 13}, {15, 16, 17}});
        System.out.println(integers);
    }
}
