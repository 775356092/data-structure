package LeeCode;

public class O_02_02 {
    //面试题 02.02. 返回倒数第 k 个节点
    //实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值
    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        int count=0;
        while(cur!=null){
            count++;
            cur = cur.next;
        }
        ListNode t = head;
        for(int i=0;i<count-k;i++){
            t=t.next;
        }
        return t.val;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
}
