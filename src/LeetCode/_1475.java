package LeetCode;

/**
 * @description: 商品折扣后的最终价格
 * @author: wang hao
 * @create: 2020-09-18 15:36
 */
public class _1475 {
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= price) {
                    price -= prices[j];
                    break;
                }
            }
            res[i] = price;
        }
        return res;
    }
}
