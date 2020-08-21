package LeetCode;

public class _1295 {
    //1295. 统计位数为偶数的数字
    //给你一个整数数组 nums，请你返回其中位数为 偶数 的数字的个数。
    public static int findNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (digits(nums[i]) % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    public static int digits(int n) {
        int count = 0;
        while (n != 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{200, 300, 400, 10}));
    }
}

