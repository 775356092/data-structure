package LeetCode;

import org.junit.Test;

/**
 * @description: 统计封闭岛屿的数量
 * @author: wang hao
 * @create: 2020-10-30 14:36
 */
public class _1254 {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int closedIsland(int[][] grid) {
        int r = grid.length, c = grid[0].length;
        int res = 0;
        for (int i = 0; i < r; i++) {
            if (grid[i][0] == 0) dfs(grid, i, 0);
            if (grid[i][c - 1] == 0) dfs(grid, i, c - 1);
        }
        for (int j = 0; j < c; j++) {
            if (grid[0][j] == 0) dfs(grid, 0, j);
            if (grid[r - 1][j] == 0) dfs(grid, r - 1, j);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 1) return;
        grid[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            dfs(grid, dx[k] + i, dy[k] + j);
        }
    }

    @Test
    public void test() {
        System.out.println(closedIsland(new int[][]{{0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}}));
    }
}
