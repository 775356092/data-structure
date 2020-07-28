package LeeCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: data-structure
 * @description: 拥有最多糖果的孩子
 * @author: wang hao
 * @create: 2020-05-12 10:54
 */
public class _1431 {
    /**
     * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
     * <p>
     * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
     */

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        ArrayList<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (extraCandies + candies[i] >= max) {
                res.add(true);
            }else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Boolean> booleans = kidsWithCandies(new int[]{12,1,12}, 10);
        System.out.println(booleans);
    }
}
