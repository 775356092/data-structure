package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 填充每个节点的下一个右侧节点指针
 * @author: wang hao
 * @create: 2020-10-15 09:01
 */
public class _116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node pre = null;
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (i != 0) pre.next = node;
                pre = node;
            }
        }
        return root;
    }

}
