package LeetCode;

/**
 * @description: 二叉搜索树转化为双向链表
 * @author: wang hao
 * @create: 2020-09-29 16:49
 */
public class O_36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    // 二叉搜索树的中序遍历 再将节点之间连接起来
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    Node head, tail;

    public void dfs(Node root) {
        if (root == null) return;
        dfs(root.left);
        //-------双向链表尾插---------
        if (tail == null) head = root;
        else tail.right = root;
        root.left = tail;
        tail = root;
        //-------双向链表尾插---------
        dfs(root.right);
    }
}
