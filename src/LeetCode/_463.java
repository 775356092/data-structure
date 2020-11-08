package LeetCode;

import org.junit.Test;

/**
 * @description: 岛屿周长
 * @author: wang hao
 * @create: 2020-10-30 09:04
 */
public class _463 {
    int[] dx = new int[]{0, 0, -1, 1};
    int[] dy = new int[]{-1, 1, 0, 0};

    public int islandPerimeter(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res += 4;
                    for (int k = 0; k < 4; k++) {
                        int tx = dx[k] + i;
                        int ty = dy[k] + j;
                        if (tx >= 0 && tx < grid.length && ty >= 0 && ty < grid[0].length && grid[tx][ty] == 1) {
                            res--;
                        }
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(islandPerimeter(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}));
    }
}
