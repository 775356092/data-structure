package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: 解数独
 * @author: wang hao
 * @create: 2020-09-04 13:24
 */
public class _37 {

    /**
     * 9*9解数独
     *
     * @param board
     */

    boolean[][] row = new boolean[9][9];//记录每行9个数字的使用情况
    boolean[][] col = new boolean[9][9];//记录每列9个数字的使用情况
    boolean[][] box = new boolean[9][9];//记录每个子方块9个数字的使用情况

    public void solveSudoku(char[][] board) {
        //初始化
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }
        dfs(board, 0);
    }

    public boolean dfs(char[][] board, int n) {
        if (n == 81) {
            return true;
        }
        int i = n / 9;
        int j = n % 9;
        if (board[i][j] != '.') {
            return dfs(board, n + 1);
        }
        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (!row[i][num] && !col[j][num] && !box[k][num]) {
                board[i][j] = (char) (num + '1');
                row[i][num] = col[j][num] = box[k][num] = true;
                if (dfs(board, n + 1)) {
                    return true;
                }
                row[i][num] = col[j][num] = box[k][num] = false;
                board[i][j] = '.';
            }
        }
        return false;
    }

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'6', '.', '.', '7', '.', '.', '.', '.', '.'},
                {'7', '.', '3', '.', '.', '8', '.', '2', '.'},
                {'.', '4', '.', '6', '.', '.', '.', '.', '.'},
                {'.', '9', '.', '.', '6', '.', '3', '.', '.'},
                {'.', '.', '8', '3', '.', '.', '.', '5', '.'},
                {'3', '.', '5', '.', '.', '.', '2', '.', '8'},
                {'.', '.', '.', '.', '4', '.', '.', '.', '3'},
                {'.', '.', '.', '.', '9', '.', '.', '1', '.'},
                {'.', '1', '.', '.', '.', '3', '9', '.', '4'}
        };
        solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
