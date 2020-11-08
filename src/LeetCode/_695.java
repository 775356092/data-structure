package LeetCode;

/**
 * @description: 岛屿的最大面积
 * @author: wang hao
 * @create: 2020-10-30 13:40
 */
public class _695 {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                    res = Math.max(count, res);
                }
            }
        }
        return res;
    }

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = 0;
        count++;
        for (int k = 0; k < 4; k++) {
            dfs(grid, dx[k] + i, dy[k] + j);
        }
    }
}
