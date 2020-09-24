package LeetCode;

/**
 * @description: 下一个排列
 * @author: wang hao
 * @create: 2020-09-24 16:25
 */
public class _31 {

    //从后向前找到第一个升序段[i, j], [j, end]降序
    //在[j, end]中从后向前找第一个大于nums[i]的数字并交换位置，交换后[j, end]必然还是降序的
    //最后反转[j, end]
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int index1 = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                index1 = i;
                break;
            }
        }
        if (index1 == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int index2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[index1]) {
                index2 = i;
                break;
            }
        }
        swap(nums, index1, index2);
        reverse(nums, index1 + 1, nums.length - 1);
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void reverse(int[] nums, int index1, int index2) {
        while (index1 < index2) {
            swap(nums, index1, index2);
            index1++;
            index2--;
        }
    }
}
