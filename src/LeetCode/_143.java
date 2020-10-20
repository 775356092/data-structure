package LeetCode;

import java.util.ArrayList;

/**
 * @description: 重排链表
 * @author: wang hao
 * @create: 2020-10-20 09:00
 */
public class _143 {
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

    public void reorderList(ListNode head) {
        if (head == null) return;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            list.add(t);
            t = t.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }
}
