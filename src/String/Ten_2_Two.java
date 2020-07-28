package String;

import java.util.Scanner;

public class Ten_2_Two {

    // 十进制转二进制 统计1的个数
    public static void m(int i){
        StringBuilder sb=new StringBuilder();
        while (i!=0){
            sb.append(i%2);
            i/=2;
        }
        sb.reverse();
        String s = sb.toString();
        char[] c = s.toCharArray();
        int res = 0;
        for(int a=0;a<c.length;a++){
            if (c[a]=='1'){
                res++;
            }
        }
        System.out.println(res);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        m(i);
    }
}
