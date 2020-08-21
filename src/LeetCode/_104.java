package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _104 {
    /**
     * 给定一个二叉树，找出其最大深度。
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     */

//DFS
public int maxDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
}

//BFS
public int depth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int res = 0;
    while (!queue.isEmpty()) {
        res++;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
    return res;
}

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
