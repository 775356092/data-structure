package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39 {
    //39.组合总数
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //candidates 中的数字可以无限制重复被选取。

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);//排序为了方便剪枝
        backTrack(res,candidates,target,new ArrayList<>(),0);
        return res;
    }

    public static void backTrack(ArrayList<List<Integer>> res,int[] candidates, int target, List<Integer> track,int start) {
        //结束条件
        if(target<0){
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(track));
        }
        //start为下一轮搜索的起点
        for (int i = start; i < candidates.length; i++){
            if(target<candidates[i]){//剪枝
                break;
            }
            track.add(candidates[i]);
            backTrack(res,candidates,target-candidates[i],track,i);
            track.remove(track.size()-1);//回溯
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(res);
    }
}
