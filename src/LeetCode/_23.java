package LeetCode;

/**
 * @description: 合并K个升序链表
 * @author: wang hao
 * @create: 2020-09-08 17:33
 */
public class _23 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
