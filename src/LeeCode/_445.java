package LeeCode;

import java.util.Stack;

public class _445 {
    //445. 两数相加 II
    //给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
    //你可以假设除了数字 0 之外，这两个数字都不会以零开头。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode res = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = 0;
            int b = 0;
            if (!stack1.isEmpty()) {
                a = stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                b = stack2.pop().val;
            }
            int sum = a + b + carry;
            ListNode listNode = new ListNode(sum % 10);
            listNode.next = res;
            res = listNode;
            carry = sum / 10;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
