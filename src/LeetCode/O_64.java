package LeetCode;

/**
 * @program: data-structure
 * @description: 求1+2+…+n
 * @author: wang hao
 * @create: 2020-06-02 08:52
 */
public class O_64 {
    /**
     * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */
    public int sumNums(int n) {
        /*return n == 0 ? 0 : n + sumNums(n - 1);*/
        boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}
