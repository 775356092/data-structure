package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 扫雷游戏
 * @author: wang hao
 * @create: 2020-08-20 09:27
 */
public class _529 {

    /**
     * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
     * <p>
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
     * <p>
     * 1.如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 2.如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 3.如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 4.如果在此次点击中，若无更多方块可被揭露，则返回面板。
     *  
     */

    //搜索位置的八个相邻位置
    int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dy = {1, 0, -1, 1, -1, 1, 0, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            bfs(board, x, y);
        }
        return board;
    }

    public void bfs(char[][] board, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int count = 0;
            for (int i = 0; i < 8; i++) {
                int tx = poll[0] + dx[i];
                int ty = poll[1] + dy[i];
                if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length) {
                    continue;
                }
                if (board[tx][ty] == 'M') {
                    count++;
                }
            }
            //如果周围有雷
            if (count > 0) {
                board[poll[0]][poll[1]] = (char) (count + '0');
            } else {
                board[poll[0]][poll[1]] = 'B';
                for (int i = 0; i < 8; i++) {
                    int tx = poll[0] + dx[i];
                    int ty = poll[1] + dy[i];
                    //这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length || board[tx][ty] != 'E' || visited[tx][ty]) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    visited[tx][ty] = true;
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        //搜索相邻的八个位置，有雷则计数
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];
            if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length) {
                continue;
            }
            if (board[tx][ty] == 'M') {
                count++;
            }
        }
        //如果周围有雷
        if (count > 0) {
            board[x][y] = (char) (count + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dx[i];
                int ty = y + dy[i];
                //这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                if (tx < 0 || ty < 0 || tx >= board.length || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }
}
