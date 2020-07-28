package LeeCode;

public class _1365 {
    //1365. 有多少小于当前数字的数字
    //给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
    //换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
    //以数组形式返回答案。
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i=0;i<res.length;i++){
            int count = 0;
            for(int j=0;j<res.length;j++){
                if(i==j){
                    continue;
                }else if(i!=j&&nums[j]<nums[i]){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
