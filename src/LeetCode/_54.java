package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 螺旋矩阵
 * @author: wang hao
 * @create: 2020-09-21 11:21
 */
public class _54 {
    /**
     * 顺时针从外到内打印矩阵
     *
     * @param matrix
     * @return
     */

    int[] dx = new int[]{0, 1, 0, -1};//右下左上
    int[] dy = new int[]{1, 0, -1, 0};

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int total = row * col;
        int[][] visited = new int[row][col];
        int i = 0, j = 0;
        int di = 0;//方向下标
        for (int t = 0; t < total; t++) {
            res.add(matrix[i][j]);
            visited[i][j]++;
            int ni = i + dx[di];
            int nj = j + dy[di];
            if (ni < 0 || ni >= row || nj < 0 || nj >= col || visited[ni][nj] == 1) {
                di = (di + 1) % 4;
            }
            i += dx[di];
            j += dy[di];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }
}
