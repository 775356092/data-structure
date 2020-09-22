package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 螺旋矩阵
 * @author: wang hao
 * @create: 2020-09-22 16:44
 */
public class _59 {
    int[] dx = new int[]{0, 1, 0, -1};
    int[] dy = new int[]{1, 0, -1, 0};

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[][] visited = new int[n][n];
        int i = 0, j = 0, di = 0;
        for (int m = 0; m < n * n; m++) {
            visited[i][j]++;
            res[i][j] = m + 1;
            int ni = i + dx[di], nj = j + dy[di];
            if (ni < 0 || nj < 0 || ni >= n || nj >= n || visited[ni][nj] == 1) {
                di = (di + 1) % 4;
            }
            i += dx[di];
            j += dy[di];
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(generateMatrix(3)));
    }
}
