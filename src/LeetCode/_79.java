package LeetCode;

import org.junit.Test;

/**
 * @Description : 单词搜索
 * @Author : wang hao
 * @Date: 2020-09-13 10:00
 */
public class _79 {

    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, 1, -1, 0};

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    int[][] visited = new int[board.length][board[0].length];
                    visited[i][j]++;
                    if (dfs(board, visited, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int[][] visited, String word, int i, int j, int index) {
        if (index == word.length() - 1) {
            return true;
        }
        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];
            int nj = j + dy[d];
            if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                if (visited[ni][nj] == 0 && board[ni][nj] == word.charAt(index + 1)) {
                    visited[ni][nj]++;
                    if (dfs(board, visited, word, ni, nj, index + 1)) {
                        return true;
                    }
                    visited[ni][nj]--;
                }
            }
        }
        return false;
    }

    @Test
    public void test() {
        //System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED"));
        //System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE"));
        //System.out.println(exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
        //System.out.println(exist(new char[][]{{'A', 'B'}, {'C', 'D'}}, "ABCD"));
        //System.out.println(exist(new char[][]{{'A', 'A'}}, "AA"));
        //System.out.println(exist(new char[][]{{'A'}}, "A"));
        //System.out.println(exist(new char[][]{{'a'}, {'a'}}, "aaa"));
        System.out.println(exist(new char[][]{{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}}, "AAB"));
    }
}
