package LeetCode;

/**
 * @description: 分隔链表
 * @author: wang hao
 * @create: 2020-11-25 10:06
 */
public class _725 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = length(root);
        int subLen = len / k;
        int t = len % k;
        res[0] = root;
        for (int i = 1; i < k; i++) {
            int l = t-- > 0 ? subLen + 1 : subLen;
            res[i] = cut(res[i - 1], l);
        }
        return res;
    }

    public int length(ListNode root) {
        ListNode cur = root;
        int res = 0;
        while (cur != null) {
            res++;
            cur = cur.next;
        }
        return res;
    }

    public ListNode cut(ListNode root, int len) {
        if (root == null) return null;
        ListNode cur = root;
        for (int i = 1; i < len && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return res;
    }
}
