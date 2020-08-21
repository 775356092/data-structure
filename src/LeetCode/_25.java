package LeetCode;

/**
 * @program: data-structure
 * @description: K 个一组翻转链表
 * @author: wang hao
 * @create: 2020-05-16 13:49
 */
public class _25 {
    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     */

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode top = new ListNode(0);
        top.next = head;
        ListNode pre = top;
        ListNode start = head;
        ListNode end = head;

        while (end != null) {
            //end指针后移
            for (int i = 0; i < k - 1; i++) {
                if (end != null) {
                    end = end.next;
                } else {
                    return top.next;
                }
            }
            if (end != null) {
                ListNode next = end.next;
                end.next = null;
                //反转
                reverse(start);
                //将反转后的链表连接到下一轮反转的头节点上
                start.next = next;
                pre.next = end;
                pre = start;
                start = next;
                end = next;
            }
        }
        return top.next;
    }

    //反转链表
    public static ListNode reverse(ListNode root) {
        ListNode pre = null;
        ListNode cur = root;
        while (cur != null) {
            //记录当前节点的后继节点
            ListNode next = cur.next;
            //指针方向反转
            cur.next = pre;
            //前继节点后移
            pre = cur;
            //当前节点后移
            cur = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode node = reverseKGroup(node1, 1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
