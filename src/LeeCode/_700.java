package LeeCode;

import java.util.LinkedList;

/**
 * @program: data-structure
 * @description: 二叉搜索树中的搜索
 * @author: wang hao
 * @create: 2020-05-15 12:42
 */
public class _700 {
    /**
     * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
     */
    //bfs层序遍历
    public TreeNode searchBST(TreeNode root, int val) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                if (node.val != val) {
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    return node;
                }
            }
        }
        return null;
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
