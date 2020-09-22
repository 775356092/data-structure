package LeetCode;

import java.util.*;

/**
 * @description: 二叉树的齿形层次遍历
 * @author: wang hao
 * @create: 2020-09-22 17:18
 */
public class _103 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int t = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            t++;
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                list.add(node.val);
            }
            if (t % 2 == 0) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
