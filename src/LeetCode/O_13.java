package LeetCode;

import org.junit.Test;

/**
 * @description: 机器人的运动范围
 * @author: wang hao
 * @create: 2020-09-21 10:20
 */
public class O_13 {
    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, 1, -1, 0};

    int res = 0;

    public int movingCount(int m, int n, int k) {
        int[][] visited = new int[m][n];
        dfs(m, n, 0, 0, visited, k);
        return res;
    }

    public void dfs(int m, int n, int i, int j, int[][] visited, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || cnt(i) + cnt(j) > k || visited[i][j] == 1) {
            return;
        }
        visited[i][j]++;
        res++;
        for (int d = 0; d < 4; d++) {
            dfs(m, n, i + dx[d], j + dy[d], visited, k);
        }
    }

    public int cnt(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }

    @Test
    public void test(){
        int i = movingCount(1, 2, 1);
        System.out.println(i);
        System.out.println(movingCount(3,2,17));
    }
}
