package LeetCode;

/**
 * @description: 换酒问题
 * @author: wang hao
 * @create: 2020-08-27 16:27
 */
public class _1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        //return numBottles + (numBottles - 1) / (numExchange - 1);
        int res = numBottles;
        int bottles = numBottles;
        while (bottles >= numExchange) {
            bottles -= numExchange;
            bottles++;
            res++;
        }
        return res;
    }
}
