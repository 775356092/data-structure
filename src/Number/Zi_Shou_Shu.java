package Number;

import java.util.Scanner;

public class Zi_Shou_Shu {

    //自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
    public static void m(int n){
        if(n==0){
            System.out.println(1);
            return;
        }
        int res = 1;
        for(int i=1;i<=n;i++){
            long a = (long) Math.pow(i,2.0);
            String s = String.valueOf(a);
            String s1 = String.valueOf(i);
            String s2 = s.substring(s.length()-s1.length());

            if (s2.equals(s1)) {
                res++;
            }

        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            m(n);
        }
    }
}
