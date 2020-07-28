package LeeCode;

import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 高度检查器
 * @author: wang hao
 * @create: 2020-05-15 12:48
 */
public class _1051 {
    /**
     * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
     * <p>
     * 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
     * <p>
     * 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。
     */

    //[5,1,2,3,4]
    //[1,2,3,4,5]
    public static int heightChecker(int[] heights) {
        int res = 0;
        int[] arr = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(arr);
        for (int i = 0; i < heights.length; i++) {
            if (arr[i] != heights[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = heightChecker(new int[]{5, 1, 2, 3, 4});
        System.out.println(i);
    }
}
