package LeetCode;

import java.util.HashMap;

/**
 * @description: 复杂链表的复制
 * @author: wang hao
 * @create: 2020-09-29 16:23
 */
public class _138 {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node t = head;
        while (t != null) {
            map.put(t, new Node(t.val));
            t = t.next;
        }
        t = head;
        while (t != null) {
            Node n = map.get(t);
            if (t.next != null) {
                n.next = map.get(t.next);
            }
            if (t.random != null) {
                n.next = map.get(t.random);
            }
            t = t.next;
        }
        return map.get(head);
    }
}
