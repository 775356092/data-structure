package LeetCode;

/**
 * @Description : 排序链表
 * @Author : wang hao
 * @Date: 2020-11-21 22:10
 */
public class _148 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 归并排序（递归）
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(right));
    }

    // 归并排序（迭代）
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        int len = length(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int subLen = 1; subLen < len; subLen *= 2) {
            ListNode tail = dummy, cur = dummy.next;
            while (cur != null) {
                ListNode h1 = cur;
                ListNode h2 = cut(h1, subLen);
                cur = cut(h2, subLen);
                tail.next = merge(h1, h2);
                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    // 合并两个有序链表
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        tail.next = left != null ? left : right;
        return dummy.next;
    }

    // 根据步长分隔链表
    public ListNode cut(ListNode head, int step) {
        if (head == null) return null;
        ListNode cur = head;
        for (int i = 1; i < step && cur.next != null; i++) {
            cur = cur.next;
        }
        ListNode right = cur.next;
        cur.next = null;
        return right;
    }

    // 获取链表长度
    public int length(ListNode head) {
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            len++;
        }
        return len;
    }
}
