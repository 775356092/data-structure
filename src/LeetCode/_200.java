package LeetCode;

/**
 * @description: 岛屿数量
 * @author: wang hao
 * @create: 2020-10-30 13:27
 */
public class _200 {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') return;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(grid, dx[k] + i, dy[k] + j);
        }
    }
}
