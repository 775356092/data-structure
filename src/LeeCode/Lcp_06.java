package LeeCode;

/**
 * @program: data-structure
 * @description: 拿硬币
 * @author: wang hao
 * @create: 2020-05-12 11:22
 */
public class Lcp_06 {
    /**
     * 桌上有 n 堆力扣币，每堆的数量保存在数组 coins 中。我们每次可以选择任意一堆，拿走其中的一枚或者两枚，求拿完所有力扣币的最少次数。
     */

    public int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] % 2 == 0) {
                res += coins[i] / 2;
            } else {
                res += coins[i] / 2 + 1;
            }
        }
        return res;
    }

}
