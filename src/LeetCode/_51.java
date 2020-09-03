package LeetCode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description: N 皇后
 * @author: wang hao
 * @create: 2020-09-03 09:10
 */
public class _51 {

    private HashSet<Integer> col = new HashSet<>();
    private HashSet<Integer> mainDiagonal = new HashSet<>();
    private HashSet<Integer> deputyDiagonal = new HashSet<>();
    private List<List<String>> res = new ArrayList<>();
    private int num;

    public List<List<String>> solveNQueens(int n) {
        num = n;
        if (n == 0) {
            return res;
        }
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        dfs(0, deque);
        return res;
    }

    public void dfs(int row, ArrayDeque<Integer> deque) {
        if (row == num) {
            res.add(convertToBoard(deque));
            return;
        }
        for (int j = 0; j < num; j++) {
            if (!col.contains(j) && !mainDiagonal.contains(row - j) && !deputyDiagonal.contains(row + j)) {
                deque.addLast(j);
                col.add(j);
                mainDiagonal.add(row - j);
                deputyDiagonal.add(row + j);
                dfs(row + 1, deque);
                deputyDiagonal.remove(row + j);
                mainDiagonal.remove(row - j);
                col.remove(j);
                deque.removeLast();
            }
        }
    }

    public List<String> convertToBoard(ArrayDeque<Integer> deque) {
        ArrayList<String> board = new ArrayList<>();
        for (Integer i : deque) {
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(num));
            sb.replace(i, i + 1, "Q");
            board.add(sb.toString());
        }
        return board;
    }

    @Test
    public void Test() {
        long current = System.currentTimeMillis();
        System.out.println(solveNQueens(5));
        long past = System.currentTimeMillis();
        System.out.println(past - current);
    }

}
