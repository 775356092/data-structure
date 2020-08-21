package LeetCode;

import java.util.LinkedList;

public class _226 {
    //翻转一棵二叉树。
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> temp;
        TreeNode res=root;
        queue.add(res);
        while (!queue.isEmpty()){
            temp = new LinkedList<>();
            for(TreeNode node:queue){
                TreeNode l = new TreeNode(0);
                l = node.left;
                node.left = node.right;
                node.right = l;
            }
            for(TreeNode node:queue){
                if(node.left!=null){
                    temp.add(node.left);
                }
                if(node.right!=null){
                    temp.add(node.right);
                }
            }
            queue = temp;
        }
        return res;
    }
}
