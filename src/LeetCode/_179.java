package LeetCode;

import java.util.ArrayList;

/**
 * @description: 最大数
 * @author: wang hao
 * @create: 2020-09-24 11:05
 */
public class _179 {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(Integer.toString(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        for (String s : list) {
            res.append(s);
        }
        return res.toString();
    }
}
