package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @description: H指数
 * @author: wang hao
 * @create: 2020-10-23 16:44
 */
public class _274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - i - 1] >= i) {
            i++;
        }
        return i;
    }

    @Test
    public void test() {
        System.out.println(hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
