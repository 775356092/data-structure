package LeeCode;

/**
 * @program: data-structure
 * @description: 斐波那契数
 * @author: wang hao
 * @create: 2020-06-01 15:18
 */
public class _509 {
    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     */
    public static int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        long past = System.currentTimeMillis();
        int fib = fib(44);
        long now = System.currentTimeMillis();
        System.out.println(fib);
        System.out.println(now - past);
    }
}
