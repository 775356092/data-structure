package LeetCode;

/**
 * @description: 最大人工岛
 * @author: wang hao
 * @create: 2020-10-30 15:31
 */
public class _827 {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    int count = 0;

    public int largestIsland(int[][] grid) {
        int res = 0, r = grid.length, c = grid[0].length;
        boolean has0 = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    boolean[][] visited = new boolean[r][c];
                    has0 = true;
                    count = 0;
                    grid[i][j] = 1;
                    dfs(grid, i, j, visited);
                    grid[i][j] = 0;
                    res = Math.max(res, count);
                }
            }
        }
        return has0 ? res : r * c;
    }

    public void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;
        count++;
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            dfs(grid, dx[k] + i, dy[k] + j, visited);
        }
    }

}
