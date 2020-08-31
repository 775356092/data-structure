package LeetCode;

/**
 * @description: 图像渲染
 * @author: wang hao
 * @create: 2020-08-28 14:30
 */
public class _733 {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, 1, -1, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            dfs(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    public void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                if (mx >= 0 && mx < image.length && my >= 0 && my < image[0].length) {
                    dfs(image, mx, my, oldColor, newColor);
                }
            }
        }
    }
}
