package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * @description: 单词接龙 II
 * @author: wang hao
 * @create: 2020-11-05 10:42
 */
public class _126 {
    ArrayList<List<String>> res = new ArrayList<>();
    // 维护每层元素和下一层元素的关系
    HashMap<String, Set<String>> map = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return res;
        dict.remove(beginWord);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 记录下一层visited，这里很关键，如果只用一个全局的visited记录每层访问过的元素，会导致缺边
            Set<String> currentVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s == null || s.equals(endWord)) break;
                for (int j = 0; j < s.length(); j++) {
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (s.charAt(j) == k) continue;
                        String t = new StringBuilder(s).replace(j, j + 1, k + "").toString();
                        if (dict.contains(t)) {
                            // 这里判断之前有没有
                            if (!visited.contains(t)) {
                                if (t.equals(endWord)) flag = true;
                                // 这里单独记录每层的访问过的元素，防止元素重复入队
                                if (!currentVisited.contains(t)) {
                                    queue.offer(t);
                                    currentVisited.add(t);
                                }
                                // 保存本层元素和下一层元素之间的关系
                                map.computeIfAbsent(s, o -> new HashSet<>());
                                map.get(s).add(t);
                            }
                        }
                    }
                }
            }
            visited.addAll(currentVisited);
        }
        if (flag) {
            dfs(beginWord, endWord, new ArrayList<>(Collections.singletonList(beginWord)));
        }
        return res;
    }

    public void dfs(String beginWord, String endWord, ArrayList<String> path) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (!map.containsKey(beginWord)) return;
        for (String s : map.get(beginWord)) {
            path.add(s);
            dfs(s, endWord, path);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test() {
        System.out.println(findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));
        System.out.println(findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
