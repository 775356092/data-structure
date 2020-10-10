package LeetCode;

/**
 * @description: 旋转链表
 * @author: wang hao
 * @create: 2020-10-10 13:45
 */
public class _61 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // k % len为每个节点需要右移的长度
    // 变向求倒数第k个节点
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode t = head, tail = head;
        // 求链表的长度
        int len = 0;
        while (t != null) {
            if (len > 0) tail = tail.next;
            t = t.next;
            len++;
        }
        // 求偏移量
        k = k % len;
        if (k == 0) return head;
        t = head;
        for (int i = 0; i < len - k - 1; i++) {
            t = t.next;
        }
        // 此时t.next节点是链表的倒数第k个节点
        ListNode res = t.next;
        tail.next = head;
        t.next = null;
        return res;
    }
}
