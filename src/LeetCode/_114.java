package LeetCode;

import java.util.ArrayList;

/**
 * @description: 二叉树展开为链表
 * @author: wang hao
 * @create: 2020-10-15 09:32
 */
public class _114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ArrayList<TreeNode> path = new ArrayList<>();
    public void flatten(TreeNode root) {
        if (root == null) return;
        preOrder(root);
        TreeNode pre = root;
        for (int i = 1; i < path.size(); i++) {
            TreeNode node = path.get(i);
            node.left = null;
            pre.right = node;
            pre = node;
        }
        root.left = null;
    }

    public void preOrder(TreeNode root) {
        if (root == null) return;
        path.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }
}
