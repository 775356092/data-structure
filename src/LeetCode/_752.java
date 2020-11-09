package LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 打开转盘锁
 * @author: wang hao
 * @create: 2020-11-09 12:55
 */
public class _752 {
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) return -1;
        int res = 1;
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        String t = new StringBuilder(s).replace(j, j + 1, ((s.charAt(j) - '0') + k + 10) % 10 + "").toString();
                        if (!set.contains(t)) {
                            if (!visited.contains(t)) {
                                if (t.equals(target)) {
                                    return res;
                                }
                                queue.offer(t);
                                visited.add(t);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    // 双向bfs
    public int openLock2(String[] deadends, String target) {
        if (target.equals("0000")) return 0;
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) return -1;
        HashSet<String> visited1 = new HashSet<>();
        visited1.add("0000");
        HashSet<String> visited2 = new HashSet<>();
        visited2.add(target);
        Queue<String> queue1 = new LinkedList<>();
        queue1.offer("0000");
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer(target);
        int res = 1;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // 优先迭代小队列
            if (queue1.size() > queue2.size()) {
                Queue<String> temp1 = queue1;
                queue1 = queue2;
                queue2 = temp1;
                HashSet<String> temp2 = visited1;
                visited1 = visited2;
                visited2 = temp2;
            }
            int size = queue1.size();
            for (int i = 0; i < size; i++) {
                String s = queue1.poll();
                for (int j = 0; j < 4; j++) {
                    for (int k = -1; k <= 1; k += 2) {
                        String t = new StringBuilder(s).replace(j, j + 1, ((s.charAt(j) - '0') + k + 10) % 10 + "").toString();
                        if (!set.contains(t)) {
                            if (!visited1.contains(t)) {
                                if (t.equals(target)) {
                                    return res;
                                }
                                if (visited2.contains(t)) {
                                    return res;
                                }
                                queue1.offer(t);
                                visited1.add(t);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return -1;
    }

    @Test
    public void test() {
        System.out.println(openLock2(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
        System.out.println(openLock2(new String[]{"8888"}, "0009"));
        System.out.println(openLock2(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println(openLock2(new String[]{"0000"}, "8888"));
    }
}
