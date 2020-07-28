package LeeCode;

import java.util.Arrays;

public class _1313 {
    //1313. 解压缩编码列表
    //给你一个以行程长度编码压缩的整数列表 nums 。
    //考虑每对相邻的两个元素 freq, val] = [nums[2*i], nums[2*i+1]] （其中 i >= 0 ），每一对都表示解压后子列表中有 freq 个值为 val 的元素，你需要从左到右连接所有子列表以生成解压后的列表。
    public static int[] decompressRLElist(int[] nums) {
        int len=0;
        for(int i=0;i<nums.length;i+=2){
            len+=nums[i];
        }
        int[] res = new int[len];
        int index=0;
        for(int i=0;i<nums.length;i+=2){
            for(int j=0;j<nums[i];j++){
                res[index] = nums[i+1];
                index++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1,2,7,8,9,10,11,12})));
    }
}
