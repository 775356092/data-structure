package LeeCode;

import java.util.Stack;

/**
 * @program: data-structure
 * @description: 平衡二叉树
 * @author: wang hao
 * @create: 2020-05-21 14:25
 */
public class _110 {
    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        return left && right;
    }

    //二叉树的深度
    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
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
