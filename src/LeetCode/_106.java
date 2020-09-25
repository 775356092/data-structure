package LeetCode;

import java.util.Arrays;

/**
 * @description: 从中序与后序遍历构造二叉树
 * @author: wang hao
 * @create: 2020-09-25 09:18
 */
public class _106 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //后序遍历的的最后一个节点为根节点
    //在中序遍历中，根结点将中序遍历序列分成了两个部分，左边是二叉树的左子树，右边是二叉树的右子树
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //后序遍历的最后一个结点为根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        //首先根据根节点在中序遍历中找到该节点，左部分为左子树，右部分为右子树。
        for (int i = 0; i < postorder.length; i++) {
            if (inorder[i] == postorder[postorder.length - 1]) {
                root.left = buildTree(Arrays.copyOfRange(inorder, 0, i), Arrays.copyOfRange(postorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length), Arrays.copyOfRange(postorder, i, postorder.length - 1));
                break;
            }
        }
        return root;
    }
}
