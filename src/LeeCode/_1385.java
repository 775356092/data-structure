package LeeCode;

/**
 * @program: data-structure
 * @description: 两个数组间的距离值
 * @author: wang hao
 * @create: 2020-05-18 12:39
 */
public class _1385 {
    /**
     * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
     * <p>
     * 「距离值」 定义为符合此描述的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
     */

    public static int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            boolean flag = true;
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) > d) {
                    flag = false;
                }else{
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int theDistanceValue = findTheDistanceValue(new int[]{1, 4, 2, 3}, new int[]{-4, -3, 6, 10, 20, 30}, 3);
        System.out.println(theDistanceValue);
    }
}
