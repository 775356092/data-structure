package LeeCode;

/**
 * @description: 寻找旋转排序数组中的最小值 II
 * @author: wang hao
 * @create: 2020-07-22 09:06
 */
public class _154 {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 请找出其中最小的元素。
     * <p>
     * 注意数组中可能存在重复的元素
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int min = findMin(new int[]{100, 25, 567, 3, 453, 355, 345, 998, 89});
        System.out.println(min);
    }
}
