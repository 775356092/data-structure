package LeetCode;

/**
 * @description: 有效的数独
 * @author: wang hao
 * @create: 2020-09-09 15:34
 */
public class _36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int index = (i / 3) * 3 + j / 3;
                    if (!row[i][num] && !col[j][num] && !box[index][num]) {
                        row[i][num] = col[j][num] = box[index][num] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
