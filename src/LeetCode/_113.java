package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 路径总和 II
 * @author: wang hao
 * @create: 2020-09-18 13:32
 */
public class _113 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    public void dfs(TreeNode root, int sum, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
            //注意这里不能return，如果return这里不会对叶子节点进行回溯
        }
        dfs(root.left, sum - root.val, path);
        dfs(root.right, sum - root.val, path);
        path.remove(path.size() - 1);
    }

    @Test
    public void test() {
        ////               5
        ////             / \
        ////            4   8
        ////           /   / \
        ////          11  13  4
        ////         /  \    / \
        ////        7    2  5   1
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        System.out.println(pathSum(root, 22));
    }
}
