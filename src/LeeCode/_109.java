package LeeCode;

/**
 * @description: 有序链表转换平衡二叉搜索树
 * @author: wang hao
 * @create: 2020-08-18 09:06
 */
public class _109 {

    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, 0, listLength(head) - 1);
    }

    public int listLength(ListNode head) {
        int res = 0;
        while (head != null) {
            head = head.next;
            res++;
        }
        return res;
    }

    public TreeNode buildTree(ListNode head, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(head, left, mid - 1);
        root.val = head.val;
        head = head.next;
        root.right = buildTree(head, mid + 1, right);
        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
