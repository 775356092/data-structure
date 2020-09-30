package LeetCode;

/**
 * @description: 阶乘后的零
 * @author: wang hao
 * @create: 2020-09-30 13:24
 */
public class _172 {

    /**
     * 10 = 2 * 5, 2出现的次数比5多, 所以找1到n有多少个5的因子
     * 1*2*3*4*(1*5)*...*(2*5)*...*(1*5*5)*...*(2*5*5)*...*(1*5*5*5)*...*(2*5*5*5)*...
     * 每隔5个数出现1个5，每隔25个数出现2个5， 每隔125个数出现3个5...
     * n/5 + n/25 + n/125 + ...
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int res = 0;
        while (n != 0) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
