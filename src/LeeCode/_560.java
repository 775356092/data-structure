package LeeCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @program: data-structure
 * @description: 和为K的子数组
 * @author: wang hao
 * @create: 2020-05-15 08:43
 */
public class _560 {
    /**
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     */
    // 暴力枚举，时间复杂度O(n^2)
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                cnt += nums[j];
                if (cnt == k) {
                    res++;
                }
            }
        }
        return res;
    }

    //构建前缀和数组，时间复杂度为O(n^2)
    public static int subarraySum2(int[] nums, int k) {
        int res = 0;
        int[] arr = new int[nums.length + 1];
        arr[0] = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (arr[j + 1] - arr[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    //hash+前缀和，时间复杂度为O(n)
    public static int subarraySum3(int nums[], int k) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        //对于下标为0的元素，前缀和为0，个数为1
        preSum.put(0, 1);
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(k - sum)) {
                res += preSum.get(k - sum);
            }
            preSum.put(sum, preSum.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }


    public static void main(String[] args) {
        int i = subarraySum2(new int[]{1, 1, 1}, 2);
        System.out.println(i);
    }
}
