package Number;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Prime_Mate {
    //素数伴侣
    //两个数加起来是素数称两个数为素数伴侣

    public static int nx;
    public static int ny;
    public static int n;
    public static boolean[][] line;
    public static boolean[] used;
    public static int[] nxt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            n = scanner.nextInt();
            nx=0;
            ny=0;
            line = new boolean[n][n];
            nxt = new int[n];
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                if (x % 2 == 0) {
                    a.add(x);
                    nx++;//偶数个数
                } else {
                    b.add(x);
                    ny++;//奇数个数
                }
            }
            for (int i = 0; i < nx; i++) {
                for (int j = 0; j < ny; j++) {
                    if (isPrime(a.get(i) + b.get(j))) {
                        line[i][j] = true;
                    }else {
                        line[i][j]= false;
                    }
                }
            }
            for (int i = 0; i < nx; i++) {
                for (int j = 0; j < ny; j++) {
                    System.out.println(line[i][j]);
                }
            }
            int sum = 0;
            for (int i = 0; i < nx; i++) {
                used = new boolean[n];
                if (find(i)) {
                    sum++;
                }
            }
            System.out.println(sum);
        }
    }

    public static boolean find(int x) {
        for (int i = 0; i < ny; i++) {
            if (line[x][i] && !used[i]) {
                used[i] = true;
                if (find(nxt[i]) || nxt[i] == 0) {
                    nxt[i] = x;
                    return true;
                }
            }
        }
        return false;
    }


    //判度一个数是否为素数
    public static boolean isPrime(int a) {
        boolean flag = true;
        if (a < 2) {// 素数不小于2
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {
                if (a % i == 0) {// 若能被整除，则说明不是素数，返回false
                    flag = false;
                    break;// 跳出循环
                }
            }
        }
        return flag;
    }
}
