package LeetCode;

/**
 * @description: 矩形面积
 * @author: wang hao
 * @create: 2020-10-22 14:51
 */
public class _223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B), area2 = (G - E) * (H - F);
        if (E >= C || A >= G || F >= D || B >= H) return area1 + area2;
        int area3 = (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
        return area1 - area3 + area2;
    }
}
