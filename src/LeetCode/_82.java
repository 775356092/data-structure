package LeetCode;

import java.util.HashMap;

/**
 * @description: 删除排序链表中的重复元素 II
 * @author: wang hao
 * @create: 2020-10-14 14:51
 */
public class _82 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode res = new ListNode(0), n = res;
        ListNode t = head;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (t != null) {
            map.put(t.val, map.getOrDefault(t.val, 0) + 1);
            t = t.next;
        }
        t = head;
        while (t != null) {
            int val = t.val;
            if (map.containsKey(val) && map.get(val) < 2) {
                map.remove(val);
                ListNode node = new ListNode(val);
                n.next = node;
                n = node;
            }
            t = t.next;
        }
        return res.next;
    }
}
