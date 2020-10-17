package LeetCode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的序列化和反序列化
 * @author: wang hao
 * @create: 2020-09-29 14:41
 */
public class _297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // dfs preOrder
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // dfs
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return buildTree(new ArrayDeque<>(Arrays.asList(arr)));
    }

    // dfs
    public TreeNode buildTree(ArrayDeque<String> deque) {
        String s = deque.poll();
        if (s.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(deque);
        root.right = buildTree(deque);
        return root;
    }

    // bfs
    public String serialize2(TreeNode root) {
        if (root == null) return "";
        StringBuilder res = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                    res.append(node.val + ",");
                } else {
                    res.append("null,");
                }
            }
        }
        return res.toString();
    }

    // bfs
    public TreeNode deserialize2(String data) {
        if (data == null || data.equals("")) {
            return null;
        }
        String[] s = data.split(",");
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        int index = 1;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (!s[index].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(s[index]));
                deque.offer(node.left);
            }
            index++;
            if (!s[index].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(s[index]));
                deque.offer(node.right);
            }
            index++;
        }
        return root;
    }

}
