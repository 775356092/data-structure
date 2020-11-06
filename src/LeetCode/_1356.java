package LeetCode;

import org.junit.Test;

import java.util.*;

/**
 * @description: 根据数字二进制下 1 的数目排序
 * @author: wang hao
 * @create: 2020-11-06 09:09
 */
public class _1356 {

    public int[] sortByBits2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 10000000;
        }
        return arr;
    }

    public int[] sortByBits(int[] arr) {
        // arr中每个数字二进制1的个数
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
            bit[x] = bitCount(x);
        }
        list.sort((x, y) -> {
            if (bit[x] != bit[y]) {
                return bit[x] - bit[y];
            } else {
                return x - y;
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int bitCount(int n) {
        int res = 0;
        while (n != 0) {
            // 清除最低位的1
            n &= (n - 1);
            res++;
        }
        return res;
    }

    public int bitCount2(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) res++;
            n >>= 1;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(sortByBits(new int[]{1024,512,256,128,64,32,16,8,4,2,1})));
    }
}
