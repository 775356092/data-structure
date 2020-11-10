package LeetCode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 蛇梯棋
 * @author: wang hao
 * @create: 2020-11-10 11:22
 */
public class _909 {
    public int snakesAndLadders(int[][] board) {
        int len = board.length;
        int total = len * len;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[total + 1];
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int begin = queue.poll();
                if (begin == total) return res;
                for (int j = 1; j <= 6; j++) {
                    int t = begin + j;
                    if (t > total) break;
                    int k = get(board, t);
                    int next = (k == -1) ? t : k;
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            res++;
        }
        return -1;
    }

    public int get(int[][] board, int index) {
        int len = board.length;
        int i = (index - 1) / len;
        int j = (index - 1) % len;
        if (i % 2 != 0) {
            j = (len - 1) - j;
        }
        i = (len - 1) - i;
        return board[i][j];
    }

    @Test
    public void test() {
        System.out.println(snakesAndLadders(new int[][]{{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}}));
        System.out.println(snakesAndLadders(new int[][]{{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}}));

    }
}
