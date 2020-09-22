package LeetCode;

import java.util.ArrayList;

/**
 * @description: 求根到叶子节点数字之和
 * @author: wang hao
 * @create: 2020-09-22 17:34
 */
public class _129 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int res = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res += count(new ArrayList<>(path));
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path.remove(path.size() - 1);
    }

    public int count(ArrayList<Integer> path) {
        int res = 0;
        for (int num : path) {
            res *= 10;
            res += num;
        }
        return res;
    }
}
