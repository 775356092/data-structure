package LeetCode;

import org.junit.Test;

/**
 * @description: 数组中的最长山脉
 * @author: wang hao
 * @create: 2020-10-21 11:07
 */
public class _845 {
    public int longestMountain(int[] arr) {
        int res = 0;
        int i = 0;
        while (i < arr.length - 1) {
            int left = i;
            if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
                    i++;
                }
                if (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                    while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
                        i++;
                    }
                    res = Math.max(res, i - left + 1);
                }
            } else {
                i++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        //System.out.println(longestMountain(new int[]{875, 884, 239, 731, 723, 685}));
        //System.out.println(longestMountain(new int[]{1, 2, 3, 2, 1, 0, 2, 3, 1}));
        //System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(longestMountain(new int[]{2, 3}));
        //System.out.println(longestMountain(new int[]{2, 2, 2}));
    }
}
