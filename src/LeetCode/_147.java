package LeetCode;

/**
 * @description: 对链表进行插入排序
 * @author: wang hao
 * @create: 2020-10-20 16:20
 */
public class _147 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head.next, pre = head;
        while (cur != null) {
            // 有序
            if (cur.val >= pre.val) {
                pre = cur;
                cur = cur.next;
            } else {
                ListNode t = dummy;
                // t < cur < t.next
                while (t.next != cur && t.next.val < cur.val) {
                    t = t.next;
                }
                pre.next = cur.next;
                cur.next = t.next;
                t.next = cur;
                cur = pre.next;
            }
        }
        return dummy.next;
    }
}
