package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冗余连接
 * @author: wang hao
 * @create: 2020-09-17 09:09
 */
public class _684 {
    /**
     * 无向图 并查集
     *
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            //如果两个节点的爸爸是同一个节点
            int parent1 = find(parent, edge[0]);
            int parent2 = find(parent, edge[1]);
            //两个节点的爸爸相同是一个环
            if (parent1 == parent2) {
                return edge;
            }
            parent[parent1] = parent2;
        }
        return new int[]{0, 0};
    }

    /**
     * 找爸爸
     *
     * @return
     */
    public int find(int[] parent, int x) {
        while (parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {1, 5}, {3, 4}, {1, 4}})));
    }
}
