package LeeCode;

import org.omg.PortableServer.LIFESPAN_POLICY_ID;

/**
 * @program: data-structure
 * @description: 合并两个有序链表
 * @author: wang hao
 * @create: 2020-05-15 11:13
 */
public class _21 {
    /**
     * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //1->2->4, 1->3->4
    //1->1->2->3->4->4
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode res = null;
        if (l1.val <= l2.val) {
            res = l1;
            l1 = l1.next;
        } else {
            res = l2;
            l2 = l2.next;
        }
        ListNode p = res;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                p.next = l2;
                return res;
            }
            if (l2 == null) {
                p.next = l1;
                return res;
            }
            if (l1.val <= l2.val) {
                p.next = l1;
                p=l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                p=l2;
                l2 = l2.next;
            }
        }
        res.next = null;
        return res;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode l = mergeTwoLists(listNode,listNode4);
        while (l!=null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}
