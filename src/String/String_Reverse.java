package String;

import java.util.Scanner;

public class String_Reverse {

    // 字符串反转
    private static void m(String s) {
        StringBuilder sb = new StringBuilder();
        char[] c = s.toCharArray();
        for(int i = c.length-1;i>=0;i--){
            sb.append(c[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        m(s);
    }

}
