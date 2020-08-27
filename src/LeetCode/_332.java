package LeetCode;

import java.util.*;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-08-27 08:56
 */
public class _332 {
    private static Map<String, PriorityQueue<String>> map = new HashMap<>();
    private static List<String> res = new LinkedList<>();

    public static List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String destination = ticket.get(1);
            if (!map.containsKey(from)) {
                map.put(from, new PriorityQueue<>());
            }
            map.get(from).offer(destination);
        }
        dfs("JFK");
        return res;
    }

    private static void dfs(String src) {
        PriorityQueue<String> queue = map.get(src);
        while (queue != null && !queue.isEmpty()) {
            dfs(queue.poll());
        }
        ((LinkedList<String>) res).addFirst(src);
    }

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("AAA");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("BBB");
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("BBB");
        list3.add("JFK");
//        ArrayList<String> list4 = new ArrayList<>();
//        list4.add("ATL");
//        list4.add("JFK");
//        ArrayList<String> list5 = new ArrayList<>();
//        list5.add("ATL");
//        list5.add("SFO");
        ArrayList<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
//        list.add(list4);
//        list.add(list5);
        List<String> itinerary = findItinerary(list);
        System.out.println(itinerary);
    }
}
