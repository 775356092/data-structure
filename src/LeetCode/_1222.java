package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 可以攻击国王的皇后
 * @author: wang hao
 * @create: 2020-09-03 14:23
 */
public class _1222 {

    //左，右，上，下，左上，右上，右下，左下
    int[] dx = new int[]{-1, 1, 0, 0, -1, 1, 1, -1};
    int[] dy = new int[]{0, 0, 1, -1, 1, 1, -1, -1};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int[][] board = new int[8][8];
        for (int[] queen : queens) {
            board[queen[0]][queen[1]]++;
        }
        for (int i = 0; i < 8; i++) {
            for (int x = king[0], y = king[1]; x < 8 && x >= 0 && y < 8 && y >= 0; x += dx[i], y += dy[i]) {
                if (board[x][y] == 1) {
                    res.add(Arrays.asList(x, y));
                    break;
                }
            }
        }
        return res;
    }

//    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
//        ArrayList<List<Integer>> res = new ArrayList<>();
//        int[][] board = new int[8][8];
//        for (int[] queen : queens) {
//            board[queen[0]][queen[1]]++;
//        }
//        int kr = king[0];
//        int kc = king[1];
//        //左
//        for (int j = kc; j >= 0; j--) {
//            if (board[kr][j] == 1) {
//                res.add(Arrays.asList(kr, j));
//                break;
//            }
//        }
//        //右
//        for (int j = kc; j < 8; j++) {
//            if (board[kr][j] == 1) {
//                res.add(Arrays.asList(kr, j));
//                break;
//            }
//        }
//        //上
//        for (int i = kr; i >= 0; i--) {
//            if (board[i][kc] == 1) {
//                res.add(Arrays.asList(i, kc));
//                break;
//            }
//        }
//        //下
//        for (int i = kr; i < 8; i++) {
//            if (board[i][kc] == 1) {
//                res.add(Arrays.asList(i, kc));
//                break;
//            }
//        }
//        //左上
//        for (int i = kr, j = kc; i >= 0 && j >= 0; i--, j--) {
//            if (board[i][j] == 1) {
//                res.add(Arrays.asList(i, j));
//                break;
//            }
//        }
//        //右下
//        for (int i = kr, j = kc; i < 8 && j < 8; i++, j++) {
//            if (board[i][j] == 1) {
//                res.add(Arrays.asList(i, j));
//                break;
//            }
//        }
//        //右上
//        for (int i = kr, j = kc; i >= 0 && j < 8; i--, j++) {
//            if (board[i][j] == 1) {
//                res.add(Arrays.asList(i, j));
//                break;
//            }
//        }
//        //左下
//        for (int i = kr, j = kc; i < 8 && j >= 0; i++, j--) {
//            if (board[i][j] == 1) {
//                res.add(Arrays.asList(i, j));
//                break;
//            }
//        }
//        return res;
//    }

    @Test
    public void test() {
        List<List<Integer>> lists = queensAttacktheKing(new int[][]{{4, 7}, {1, 3}, {6, 6}, {3, 0}, {0, 2}, {0, 7}, {6, 2}, {3, 7}, {5, 1}, {2, 5}, {0, 3}, {7, 2}, {4, 0}, {1, 2}, {3, 3}, {5, 5}, {4, 4}, {6, 3}, {1, 5}, {5, 0}, {0, 4}, {6, 4}, {5, 4}, {3, 2}, {0, 0}, {4, 5}, {0, 5}, {2, 3}, {1, 0}, {6, 5}, {5, 3}, {0, 1}, {7, 0}, {4, 6}, {5, 7}, {7, 4}, {2, 0}, {4, 3}, {3, 4}}, new int[]{2, 4});
        System.out.println(lists);
    }
}
