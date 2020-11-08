package LeetCode;

import org.junit.Test;

/**
 * @description: 被环绕的区域
 * @author: wang hao
 * @create: 2020-11-02 13:49
 */
public class _130 {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        if (c == 0) return;
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][c - 1] == 'O') dfs(board, i, c - 1);
        }
        for (int j = 0; j < c; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[r - 1][j] == 'O') dfs(board, r - 1, j);
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'n') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X') return;
        board[i][j] = 'n';
        for (int k = 0; k < 4; k++) {
            dfs(board, i + dx[k], j + dy[k]);
        }
    }

    @Test
    public void test() {
        solve(new char[][]{{}});
    }
}
