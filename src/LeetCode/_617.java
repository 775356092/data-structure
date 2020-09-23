package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: data-structure
 * @description: 合并二叉树
 * @author: wang hao
 * @create: 2020-05-12 13:26
 */
public class _617 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
     * <p>
     * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
     */
    //dfs
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    //bfs
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);
        queue.offer(t2);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            node1.val += node2.val;
            //左子树都不为空
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            } else if (node1.left == null) {
                node1.left = node2.left;
            }
            //右子树都不为空
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            } else if (node1.right == null) {
                node1.right = node2.right;
            }
        }
        return t1;
    }

}
