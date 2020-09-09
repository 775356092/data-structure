package LeetCode;

import org.junit.Test;

/**
 * @description: 缀点成线
 * @author: wang hao
 * @create: 2020-09-09 16:51
 */
public class _1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        boolean flag = false;
        float k = 0;
        if (x1 == x2) {
            flag = true;
        } else {
            k = (float) (y2 - y1) / (x2 - x1);
        }
        for (int i = 1; i < coordinates.length - 1; i++) {
            if (flag) {
                if (coordinates[i][0] != x1) {
                    return false;
                }
                continue;
            }
            x1 = coordinates[i][0];
            y1 = coordinates[i][1];
            x2 = coordinates[i + 1][0];
            y2 = coordinates[i + 1][1];
            if (x1 == x2) {
                return false;
            }
            float temp = (float) (y2 - y1) / (x2 - x1);
            if (temp != k) {
                return false;
            }
        }
        if (flag) {
            return coordinates[coordinates.length - 1][0] == x1;
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(checkStraightLine(new int[][]{{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}}));
    }
}
