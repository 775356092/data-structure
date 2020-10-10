package LeetCode;

import java.util.HashSet;

/**
 * @description: 环形链表 II
 * @author: wang hao
 * @create: 2020-10-10 08:56
 */
public class _142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //hash表
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode t = head;
        while (t != null) {
            if (set.contains(t)) {
                return t;
            }
            set.add(t);
            t = t.next;
        }
        return null;
    }

    //双指针
    public ListNode detectCycle2(ListNode head) {
        // 设链表到入环的第一个节点长度为a
        // 慢指针再走a步就可以到达入环的第一个节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                ListNode t = head;
                while (t != slow) {
                    t = t.next;
                    slow = slow.next;
                }
                return t;
            }
        }
        return null;
    }
}
