package LeeCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: wang hao
 * @create: 2020-05-22 08:47
 */
public class _105 {
    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * 注意:你可以假设树中没有重复的元素。
     */
    //前序遍历的第一个结点就是二叉树的根结点
    //在中序遍历中，根结点将中序遍历序列分成了两个部分，左边是二叉树的左子树，右边是二叉树的右子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //终止条件，数组长度为0
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //前序遍历中第一个结点为根节点
        TreeNode root = new TreeNode(preorder[0]);
        //首先根据根结点在中序遍历中找到该结点，左部分为左子树，右部分为右子树。
        //然后递归，在左子树的前序中第一个为根节点，以根节点在中序遍历中找到该节点，左部分为左子树，右部分为右子树。一层一层往下递归
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
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
