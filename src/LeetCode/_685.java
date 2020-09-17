package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 冗余连接 II
 * @author: wang hao
 * @create: 2020-09-17 09:09
 */
public class _685 {

    /**
     * 有向图 并查集
     *
     * @param edges
     * @return
     */
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] inDegree = new int[edges.length + 1];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        int[] parent = new int[edges.length + 1];
        for (int i = 1; i < edges.length; i++) {
            parent[i] = i;
        }
        int node = -1;//是否有入度为2的结点
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 2) {
                node = i;
                break;
            }
        }
        //如果有入度为2的结点，则必有一条边满足题解
        if (node != -1) {
            int left1 = -1;//如果不行则返回这条边
            int left2 = -1;//先删这条边
            for (int i = 0; i < edges.length; i++) {
                if (node == edges[i][1]) {
                    if (left1 == -1) {
                        left1 = edges[i][0];
                    } else {
                        left2 = edges[i][0];
                    }
                }
            }
            //判断剩下来的边是否会形成环
            boolean hasCircle = false;
            for (int[] edge : edges) {
                if (edge[0] == left2 && edge[1] == node) {
                    continue;
                }
                int parent1 = find(parent, edge[0]);
                int parent2 = find(parent, edge[1]);
                if (parent1 == parent2) {
                    hasCircle = true;
                    break;
                }
                parent[parent1] = parent2;
            }
            if (!hasCircle) {
                return new int[]{left2, node};
            }
            return new int[]{left1, node};

        } else {//入度都为1说明有向图形成了局部环 --> 684题解
            for (int[] edge : edges) {
                int parent1 = find(parent, edge[0]);
                int parent2 = find(parent, edge[1]);
                if (parent1 == parent2) {
                    return edge;
                }
                parent[parent1] = parent2;
            }
        }
        return new int[]{0, 0};
    }

    /**
     * 找爸爸
     *
     * @param parent
     * @param x
     * @return
     */
    public int find(int[] parent, int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }


    @Test
    public void test() {
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})));
        System.out.println(Arrays.toString(findRedundantDirectedConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}})));
    }

}
