package Number;

import java.util.Scanner;

public class Snake_Arr {
    //蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形
    //样例输入
    //5
    //样例输出
    //1 3 6 10 15
    //2 5 9 14
    //4 8 13
    //7 12
    //11
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[][] arr = new int[n][n];
            int count = 1;
            for (int i = 0, j = 0; i < n && j < n; i++) {
                int a = i,b=j;
                while (a >= 0 && b < n) {
                    arr[a][b] = count;
                    count++;
                    a--;
                    b++;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(arr[i][j]!=0){
                        System.out.print(arr[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
    }
}
