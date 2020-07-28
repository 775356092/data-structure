package Knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //有n钱
        int n = in.nextInt();
        //要买m个东西
        int m = in.nextInt();
        int[] f = new int[n + 1];

        Good[][] goods = new Good[60][3];
        for (int i = 0; i < m; i++) {
            int value = in.nextInt();
            int weight = in.nextInt();
            int sub = in.nextInt();
            Good tempGood = new Good(value, value * weight);
            if (sub == 0) {
                goods[i][0] = tempGood;
            } else {
                if (goods[sub - 1][1] == null) {
                    goods[sub - 1][1] = tempGood;
                } else {
                    goods[sub - 1][2] = tempGood;
                }
            }

        }
        //完成商品录入
        for (int i = 0; i < m; i++) {
            for (int j = n; j > 0 && goods[i][0] != null; j--) {
                Good a = goods[i][0];
                if (j >= a.v && (f[j - a.v] + a.vp > f[j])) {
                    f[j] = f[j - a.v] + a.vp;
                }
                if (goods[i][1] != null) {
                    Good b = goods[i][1];
                    if (j >= (a.v + b.v) && (f[j - a.v - b.v] + a.vp + b.vp > f[j])) {
                        f[j] = f[j - a.v - b.v] + a.vp + b.vp;
                    }
                    if (goods[i][2] != null) {
                        Good c = goods[i][2];
                        if (j >= (a.v + c.v) && (f[j - a.v - c.v] + a.vp + c.vp > f[j])) {
                            f[j] = f[j - a.v - c.v] + a.vp + c.vp;
                        }
                        if (j >= (a.v + b.v + c.v) && (f[j - a.v - b.v - c.v] + a.vp + b.vp + c.vp > f[j])) {
                            f[j] = f[j - a.v - b.v - c.v] + a.vp + b.vp + c.vp;
                        }

                    }
                }

            }

        }
        System.out.println(f[n]);
    }
}

class Good {
    int v;
    int vp;

    public Good(int v, int vp) {
        this.v = v;
        this.vp = vp;
    }
}