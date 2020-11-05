package LeetCode;

import java.util.HashMap;

/**
 * @description: LRU缓存机制
 * @author: wang hao
 * @create: 2020-11-5 16:55
 */
public class _146 {
    class Node {
        public int key, val;
        public Node pre, next;

        public Node(int k, int v) {
            this.key = k;
            this.val = v;
        }
    }

    // 双向链表
    // 为什么要双向链表，因为在删除节点时需要前驱节点
    class DoubleList {

        private Node head, tail;
        private int size;

        // 在链表头部添加节点node, O(1)
        public void addFirst(Node node) {
            if (head == null) head = tail = node;
            head.pre = node;
            node.next = head;
            head = node;
            size++;
        }

        // 删除链表中的node节点, O(1)
        public void remove(Node node) {
            if (head == node && tail == node) {
                head = tail = null;
            } else if (head == node) {
                node.next.pre = null;
                head = node.next;
            } else if (tail == node) {
                node.pre.next = null;
                tail = node.pre;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            size--;
        }

        // 删除链表的尾节点, O(1)
        public Node removeLast() {
            Node node = tail;
            remove(tail);
            return node;
        }

        // 返回链表的长度
        public int size() {
            return size;
        }
    }

    class LRUCache {
        private HashMap<Integer, Node> map;
        private DoubleList cache;
        private int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            cache = new DoubleList();
            this.capacity = capacity;
        }

        public int get(int key) {
            // 如果key不存在，返回-1
            if (!map.containsKey(key)) return -1;
            // 否则将数据放到链表头部
            int val = map.get(key).val;
            put(key, val);
            return val;
        }

        // 如果容量满了，需要删除最久未使用的元素
        public void put(int key, int value) {
            Node node = new Node(key, value);
            // 如果key已经存在，删除原有的节点
            if (map.containsKey(key)) {
                cache.remove(map.get(key));
            } else {
                // 如果缓存已满，删除链表尾部节点
                if (capacity == cache.size()) {
                    Node last = cache.removeLast();
                    map.remove(last.key);
                }
            }
            cache.addFirst(node);
            map.put(key, node);
        }
    }

}
