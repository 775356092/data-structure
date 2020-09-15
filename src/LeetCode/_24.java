package LeetCode;

/**
 * @description: 两两交换链表中的节点
 * @author: wang hao
 * @create: 2020-09-08 16:43
 */
public class _24 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;
        return second;
    }
}
