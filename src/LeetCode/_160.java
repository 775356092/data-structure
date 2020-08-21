package LeetCode;

import java.util.HashSet;

/**
 * @program: data-structure
 * @description: 相交链表
 * @author: wang hao
 * @create: 2020-05-20 16:09
 */
public class _160 {
    /**
     * 编写一个程序，找到两个单链表相交的起始节点。
     */
    //hashset 时间复杂度O(m+n),空间复杂度O(m)或O(n)
    public ListNode getIntersection(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    //双指针法，A+C+B=B+C+A 时间复杂度O(m+n),空间复杂度O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
