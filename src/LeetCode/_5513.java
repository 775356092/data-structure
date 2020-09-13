package LeetCode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description :
 * @Author : wang hao
 * @Date: 2020-09-13 11:39
 */
public class _5513 {
    ArrayList<Integer> res = new ArrayList<>();

    public int minCostConnectPoints(int[][] points) {
        int[] visited = new int[points.length];
        dfs(points, visited, new ArrayList<>());
        int ans = Integer.MAX_VALUE;
        for (Integer re : res) {
            ans = Math.min(ans, re);
        }
        return ans;
    }

    public void dfs(int[][] points, int[] visited, ArrayList<Integer> path) {

        if (path.size() == points.length) {
            res.add(cal(path, points));
            return;
        }
        for (int i = 0; i < points.length; i++) {
            if (visited[i] == 0) {
                path.add(i);
                visited[i]++;
                dfs(points, visited, path);
                visited[i]--;
                path.remove(path.size() - 1);
            }
        }
    }

    public int cal(ArrayList<Integer> list, int[][] points) {
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int x1 = points[list.get(i)][0];
            int y1 = points[list.get(i)][1];
            int x2 = points[list.get(i + 1)][0];
            int y2 = points[list.get(i + 1)][1];
            res += Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}}));
    }
}
