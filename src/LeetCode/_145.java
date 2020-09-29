package LeetCode;

import java.util.*;

/**
 * @description: 二叉树的后序遍历
 * @author: wang hao
 * @create: 2020-09-14 09:22
 */
public class _145 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<Integer> res = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
        res.add(root.val);
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode t = root;
        while (t != null || !stack.isEmpty()) {
            if (t != null) {
                stack.push(t);
                res.addFirst(t.val);
                t = t.right;
            } else {
                t = stack.pop().left;
            }
        }
        return res;
    }


}
