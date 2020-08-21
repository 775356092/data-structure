package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure
 * @description: N叉树的后序遍历
 * @author: wang hao
 * @create: 2020-05-15 13:58
 */
public class _590 {
    /**
     * 给定一个 N 叉树，返回其节点值的后序遍历。
     */

    ArrayList<Integer> res = new ArrayList<>();

    //bfs
    public List<Integer> postorder(Node root) {
        recursion(root);
        return res;

    }

    //递归
    public void recursion(Node root) {
        if (root == null) {
            return;
        }
        int s = root.children.size();
        for (int i = 0; i < s; i++) {
            recursion(root.children.get(i));
        }
        res.add(root.val);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
