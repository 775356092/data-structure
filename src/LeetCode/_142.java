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

    /**
     * 设表头到入口节点长度为a, 环的长度为b, 快指针走了x, 慢指针走了y
     * 快指针比慢指针多走了一倍的路, x = 2y
     * 快指针比慢指针多走了n圈, x = n * b + y ==> y = n * b
     * 快指针走了2n圈, 慢指针走了n圈
     * 所有走到链表入口节点时的步数: k = a + n * b（先走 a 步到入口节点，之后每绕 1 圈环 b 步）都会再次到入口节点
     * 在相遇点，慢指针再走a步就可以到达入口节点
     */
    public ListNode detectCycle2(ListNode head) {
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
