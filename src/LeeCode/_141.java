package LeeCode;

import java.util.HashSet;

public class _141 {
    //141. 环形链表
    //给定一个链表，判断链表中是否有环。

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return true;
            }else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
