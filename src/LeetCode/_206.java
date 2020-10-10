package LeetCode;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 反转链表
 * @author: wang hao
 * @create: 2020-10-10 14:40
 */
public class _206 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //迭代
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (!stack.isEmpty()) {
            ListNode res = stack.pop();
            ListNode l = res;
            while (!stack.isEmpty()) {//尾插
                ListNode node = null;
                node = stack.pop();
                l.next = node;
                l = node;
            }
            l.next = null;
            return res;
        }
        return null;
    }

    //递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    @Test
    public void test() {
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        ListNode node1 = reverseList(node);
        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
    }
}
