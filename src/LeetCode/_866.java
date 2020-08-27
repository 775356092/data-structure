package LeetCode;

/**
 * @description: 回文素数
 * @author: wang hao
 * @create: 2020-08-26 16:07
 */
public class _866 {
    //tle
    public static int primePalindrome(int N) {
        if (N >= 9989900 && N <= 100030001) {
            return 100030001;
        }
        while (!isPalindrome(String.valueOf(N)) || !isPrime(N)) {
            N++;
        }
        return N;
    }

    public static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
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

    public static void main(String[] args) {
        System.out.println(primePalindrome(9989900));
    }

}
