package LeetCode;

/**
 * @description: 排除数组中的重复项
 * @author: wang hao
 * @create: 2020-08-31 10:17
 */
public class _26 {
    public int removeDuplicates(int nums[]) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
