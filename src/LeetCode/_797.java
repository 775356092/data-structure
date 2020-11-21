package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 所有可能的路径
 * @author: wang hao
 * @create: 2020-11-19 10:25
 */
public class _797 {
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, path, 0);
        return res;
    }

    public void dfs(int[][] graph, ArrayList<Integer> path, int start) {
        if (path.get(path.size() - 1) == graph.length - 1) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph[start].length; i++) {
            int node = graph[start][i];
            path.add(node);
            dfs(graph, path, node);
            path.remove(path.size() - 1);
        }
    }
}
