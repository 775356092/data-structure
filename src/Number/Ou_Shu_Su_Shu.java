package Number;

import java.util.Scanner;

public class Ou_Shu_Su_Shu {
    //任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int a = 0;
            int b = 0;
            for(int i=1;i<=n/2;i++){
                if(isPrime(i)&&isPrime(n-i)){
                    a = i;
                    b = n - i;
                }
            }
            System.out.println(a);
            System.out.println(b);
        }
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
