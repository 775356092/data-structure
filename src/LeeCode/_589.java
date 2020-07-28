package LeeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure
 * @description: N叉树的前序遍历
 * @author: wang hao
 * @create: 2020-05-15 16:13
 */
public class _589 {
    /**
     * 给定一个 N 叉树，返回其节点值的前序遍历。
     */

    List<Integer> res = new ArrayList<Integer>();

    public List<Integer> preorder(Node root) {
        recursion(root);
        return res;
    }

    //递归
    public void recursion(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        int s = root.children.size();
        for (int i = 0; i < s; i++) {
            recursion(root.children.get(i));
        }
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
