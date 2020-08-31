package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 朋友圈
 * @author: wang hao
 * @create: 2020-08-28 09:18
 */
public class _547 {

    public static int findCircleNum(int[][] M) {
        int res = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }

    public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j]++;
                dfs(M, visited, j);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(findCircleNum(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }
}
