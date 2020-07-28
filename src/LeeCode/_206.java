package LeeCode;

import com.sun.org.apache.xpath.internal.objects.XNodeSet;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _206 {
    //反转链表
    public static ListNode reverseList(ListNode head) {
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

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
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
            System.out.print(node1.val+" ");
            node1= node1.next;
        }
    }
}
