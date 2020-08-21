package LeetCode;

import java.util.Arrays;

public class _1389 {
    //1389. 按既定顺序创建目标数组
    //给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：
    //目标数组 target 最初为空。
    //按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
    //重复上一步，直到在 nums 和 index 中都没有要读取的元素。
    //请你返回目标数组。
    //题目保证数字插入位置总是存在。
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] res = new int[index.length];
        for(int i=0;i<nums.length;i++){
            int target = nums[i];
            int n = index[i];
            for(int j=res.length-1;j>n;j--){
                res[j]=res[j-1];
            }
            res[n] = target;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[]{0,1,2,3,4},new int[]{0,1,2,2,1})));
    }
}
