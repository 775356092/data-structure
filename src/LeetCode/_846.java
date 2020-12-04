package LeetCode;

import java.util.Arrays;

/**
 * @description: 一手顺子
 * @author: wang hao
 * @create: 2020-11-26 10:49
 */
public class _846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (W == 1) return true;
        int len = hand.length;
        if (len % W != 0) return false;
        Arrays.sort(hand);
        boolean[] visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                int start = hand[i];
                int t = W;
                for (int j = i; j < len && t > 0; j++) {
                    if (!visited[j] && hand[j] == start) {
                        visited[j] = true;
                        start++;
                        t--;
                    }
                }
                if (t > 0) return false;
            }
        }
        return true;
    }
}
