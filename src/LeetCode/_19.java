package LeetCode;

/**
 * @description: 删除链表的倒数第N个节点
 * @author: wang hao
 * @create: 2020-09-08 15:20
 */
public class _19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode left = pre;
        ListNode right = pre;
        int x = 0;
        while (right.next != null) {
            x++;
            right = right.next;
            if (x > n) {
                left = left.next;
            }
        }
        left.next = left.next.next;
        return pre.next;
    }
}
