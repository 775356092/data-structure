package LeetCode;

/**
 * @description: 反转链表 II
 * @author: wang hao
 * @create: 2020-10-10 15:02
 */
public class _92 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode res = new ListNode(0);
        res.next = head;
        // 找到需要反转部分的前一个节点t
        ListNode t = res;
        for (int i = 0; i < m - 1; i++) {
            t = t.next;
        }
        // t.next为需要反转的链表
        ListNode l = t.next;
        ListNode r = t.next;
        for (int i = 0; i < n - m; i++) {
            r = r.next;
        }
        // 找到需要反转部分最后的后一个节点p
        ListNode p = r.next;
        r.next = null;
        // 将反转的链表头部接到t上
        t.next = reverse(l);
        // 将反转的链表尾部接到p上
        l.next = p;
        return res.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
