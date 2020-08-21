package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: data-structure
 * @description: N叉树的最大深度
 * @author: wang hao
 * @create: 2020-05-19 00:08
 */
public class _559 {
    /**
     * 给定一个 N 叉树，找到其最大深度。
     *
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     */

    //BFS
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int count = queue.size();
            res++;
            while (count > 0) {
                Node node = queue.poll();
                for (Node n : node.children) {
                    queue.add(n);
                }
                count--;
            }
        }
        return res;
    }

    //DFS


    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
