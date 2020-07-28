package LeeCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 将每个元素替换为右侧最大元素
 * @author: wang hao
 * @create: 2020-05-12 13:19
 */
public class _1299 {
    /**
     * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
     * <p>
     * 完成所有替换操作后，请你返回这个数组。
     */
    public static int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            if (i == arr.length - 1) {
                arr[i] = -1;
                break;
            }
            for (int j = i+1; j < arr.length; j++) {
                if (max < arr[j]) {
                    max = arr[j];
                }
            }
            arr[i] = max;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = replaceElements(new int[]{17, 18, 5, 4, 6, 1});
        System.out.println(Arrays.toString(ints));
    }
}
