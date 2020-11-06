package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description: 二叉树的右视图
 * @author: wang hao
 * @create: 2020-11-06 11:27
 */
public class _199 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> rightSideView2(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }

    ArrayList<Integer> res = new ArrayList<>();
    int deepest = 0;
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) return;
        if (deepest == depth) {
            res.add(root.val);
            deepest++;
        }
        dfs(root.right, depth + 1);
        dfs(root.left, depth + 1);
    }
}
