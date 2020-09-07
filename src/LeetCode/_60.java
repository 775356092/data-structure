package LeetCode;

import org.junit.Test;

/**
 * 第k个排列
 */
public class _60 {

    String res;
    int pos;
    int count = 0;

    public String getPermutation(int n, int k) {
        pos = k;
        int[] visited = new int[n + 1];
        dfs(n, new StringBuilder(), visited);
        return res;
    }

    public void dfs(int n, StringBuilder sb, int[] visited) {
        if (sb.length() == n) {
            count++;
            if (count == pos) {
                res = sb.toString();
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (count == pos) {
                break;
            }
            if (visited[i] == 0) {
                visited[i]++;
                dfs(n, sb.append(i), visited);
                visited[i]--;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    @Test
    public void test() {
        System.out.println(getPermutation(3, 3));
    }


}
