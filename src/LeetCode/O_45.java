package LeetCode;

import java.util.ArrayList;

/**
 * @description: 把数组排成最小的数
 * @author: wang hao
 * @create: 2020-09-25 14:30
 */
public class O_45 {
    public String minNumber(int[] nums) {
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
