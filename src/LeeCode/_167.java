package LeeCode;

/**
 * @description: 两数之和 II - 输入有序数组
 * @author: wang hao
 * @create: 2020-07-20 08:33
 */
public class _167 {

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 说明:
     * <p>
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        /*for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    res[0] = i + 1;
                    res[1] = j + 1;
                    break;
                }
            }
        }*/
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                break;
            }
            if (numbers[i] + numbers[j] < target) {
                i++;
                continue;
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            }
        }
        res[0] = i + 1;
        res[1] = j + 1;
        return res;
    }
}
