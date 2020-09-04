package LeetCode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的所有路径
 * @author: wang hao
 * @create: 2020-08-28 13:33
 */
public class _257 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<String> res = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
                if (i != path.size() - 1) {
                    sb.append("->");
                }
            }
            res.add(sb.toString());
        }
        dfs(root.left);
        dfs(root.right);
        path.remove(path.size() - 1);
    }

    /*public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String s) {
        if (root == null) {
            return;
        }
        s += root.val + "";
        if (root.left == null && root.right == null) {
            res.add(s);
        }
        s += "->";
        dfs(root.left, s);
        dfs(root.right, s);
    }*/

    @Test
    public void Test() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        List<String> list = binaryTreePaths(root);
        System.out.println(list);
    }
}
