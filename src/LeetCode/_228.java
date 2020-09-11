package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 汇总区间
 * @author: wang hao
 * @create: 2020-09-11 09:31
 */
public class _228 {

    //[0,2,3,4,6,8,9]
    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0] + "");
            return res;
        }
        int left = nums[0];
        int right = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != right + 1) {
                if (left != right) {
                    res.add(left + "->" + right);
                } else {
                    res.add(left + "");
                }
                left = right = nums[i];
            } else {
                right++;
            }
            if (i == nums.length - 1) {
                if (left != right) {
                    res.add(left + "->" + right);
                } else {
                    res.add(right + "");
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }
}
