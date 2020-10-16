package LeetCode;

import java.util.ArrayList;

/**
 * @description: 回文链表
 * @author: wang hao
 * @create: 2020-10-16 16:19
 */
public class _234 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode h = head;
        while (h != null) {
            list.add(h.val);
            h = h.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
