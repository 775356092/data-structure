package Knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopping_Cart {

    // 华为机试：购物车（背包问题）
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);// 总钱数
        int m = Integer.parseInt(s1[1]);// 购买个数
        int[] v = new int[m + 1]; // 商品价格
        int[] p = new int[m + 1]; // 商品重要度
        int[] q = new int[m + 1]; // 商品是否为主件
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            String s2 = scanner.nextLine();
            String[] s3 = s2.split(" ");
            v[i] = Integer.parseInt(s3[0]);
            p[i] = Integer.parseInt(s3[1]) * v[i];
            q[i] = Integer.parseInt(s3[2]);
        }

        // 01背包问题
        // 计算容量为n，能拿m个东西的最大价值
        // 如果剩余物品容量<要拿的物品容量 --> 拿不了 dp[m][n] = dp[m-1][n]
        // dp[m][n] = max(拿--> dp[m-1][n], 不拿--> dp[m-1][n-物品容量]+物品价值)

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (q[i] == 0) {
                    if (v[i] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + p[i]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                } else {
                    if (v[i] + v[q[i]] <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + p[i]);
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
        }
      System.out.println(dp[m][n]);
    }
}
