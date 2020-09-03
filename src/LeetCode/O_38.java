package LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class O_38 {

    HashSet<String> res = new HashSet<String>();

    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        int[] visited = new int[s.length()];
        dfs(visited, "", s.toCharArray());
        String[] result = new String[res.size()];
        return res.toArray(result);
    }

    public void dfs(int[] visited, String letter, char[] chars) {
        if (chars.length == letter.length()) {
            res.add(letter);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (visited[i] == 0) {
                visited[i]++;
                dfs(visited, letter + chars[i], chars);
                visited[i]--;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(permutation("1234")));
    }
}
