package LeetCode;

/**
 * @program: data-structure
 * @description: 位1的个数
 * @author: wang hao
 * @create: 2020-05-15 12:37
 */
public class _191 {
    /**
     * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
     */
    public int hammingWeight(int n) {
        int res = 0;
        for(int i=31;i>=0;i--){
            if((n>>>i&1)==1){
                res++;
            }
        }
        return res;
    }
}
