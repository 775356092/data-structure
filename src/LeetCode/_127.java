package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * @description: 单词接龙
 * @author: wang hao
 * @create: 2020-11-05 08:59
 */
public class _127 {
    // bfs
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        set.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                // 尝试更换s每个位置的字符，看是否在set中
                for (int j = 0; j < s.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == s.charAt(j)) continue;
                        String t = new StringBuilder(s).replace(j, j + 1, k + "").toString();
                        if (set.contains(t)) {
                            if (t.equals(endWord)) return res + 1;
                            if (!visited.contains(t)) {
                                queue.offer(t);
                                visited.add(t);
                            }
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }

    // 双向bfs
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> queue1 = new LinkedList<>();
        queue1.offer(beginWord);
        Queue<String> queue2 = new LinkedList<>();
        queue2.offer(endWord);
        HashSet<String> visited1 = new HashSet<>();
        HashSet<String> visited2 = new HashSet<>();
        visited1.add(beginWord);
        visited2.add(endWord);
        int res = 2;
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // 优先迭代小队列
            if (queue1.size() > queue2.size()) {
                int size = queue2.size();
                for (int i = 0; i < size; i++) {
                    String s = queue2.poll();
                    // 尝试更换s每个位置的字符，看是否在set中
                    for (int j = 0; j < s.length(); j++) {
                        for (char k = 'a'; k <= 'z'; k++) {
                            if (k == s.charAt(j)) continue;
                            String t = new StringBuilder(s).replace(j, j + 1, k + "").toString();
                            if (set.contains(t)) {
                                if (t.equals(beginWord)) return res;
                                if (visited1.contains(t)) return res;
                                if (!visited2.contains(t)) {
                                    queue2.offer(t);
                                    visited2.add(t);
                                }
                            }
                        }
                    }
                }
            } else {
                int size = queue1.size();
                for (int i = 0; i < size; i++) {
                    String s = queue1.poll();
                    // 尝试更换s每个位置的字符，看是否在set中
                    for (int j = 0; j < s.length(); j++) {
                        for (char k = 'a'; k <= 'z'; k++) {
                            if (k == s.charAt(j)) continue;
                            String t = new StringBuilder(s).replace(j, j + 1, k + "").toString();
                            if (set.contains(t)) {
                                if (t.equals(endWord)) return res;
                                if (visited2.contains(t)) return res;
                                if (!visited1.contains(t)) {
                                    queue1.offer(t);
                                    visited1.add(t);
                                }
                            }
                        }
                    }
                }
            }
            res++;
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(ladderLength2("a", "c", Arrays.asList("a", "b", "c")));
    }

}
