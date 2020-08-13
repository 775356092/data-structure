package LeeCode;

import java.util.*;

/**
 * @description: 克隆图
 * @author: wang hao
 * @create: 2020-08-12 09:29
 */
public class _133 {

    /**
     * 图的遍历
     */
    public Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    //深度优先搜索
    public Node dfs(Node node, HashMap<Node, Node> pre) {
        if (node == null) {
            return null;
        }
        if (pre.containsKey(node)) {
            return pre.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        //记录被克隆过的节点
        pre.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, pre));
        }
        return clone;
    }

    //广度优先搜索
    public Node bfs(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone);
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            for (Node n : temp.neighbors) {
                if (!visited.containsKey(n)) {
                    visited.put(n, new Node(n.val, new ArrayList<Node>()));
                    queue.offer(n);
                }
                visited.get(temp).neighbors.add(visited.get(n));
            }
        }
        return clone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
