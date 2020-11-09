package LeetCode;

import java.util.HashSet;

/**
 * @Description : N皇后 II
 * @Author : wang hao
 * @Date: 2020-10-17 10:50
 */
public class _52 {
    HashSet<Integer> c = new HashSet<>();
    HashSet<Integer> m = new HashSet<>();
    HashSet<Integer> e = new HashSet<>();
    int res;
    public int totalNQueens(int n) {
        dfs(n, 0);
        return res;
    }

    public void dfs(int n, int row) {
        if (row == n) {
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!c.contains(i) && !m.contains(row - i) && !e.contains(row + i)) {
                c.add(i);
                m.add(row - i);
                e.add(row + i);
                dfs(n, row + 1);
                e.remove(row + i);
                m.remove(row - i);
                c.remove(i);
            }
        }
    }
}
