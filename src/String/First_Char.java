package String;

import java.util.Scanner;

public class First_Char {

    //找出字符串中第一个只出现一次的字符

    public static void m(String s) {
        char res=s.charAt(0);
        int a=0;
        for (int i = 0; i < s.length(); i++) {
            boolean flag = true;
            char c = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if(i!=j&&c==s.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                res = c;
                a=1;
                System.out.println(res);
                break;
            }else {
                a=0;
            }
        }
        if(a==0){
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            m(s);
        }
    }
}
