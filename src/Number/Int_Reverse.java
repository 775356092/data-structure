package Number;

import java.util.Scanner;

public class Int_Reverse {

    public static void m(int a){
        StringBuilder sb = new StringBuilder();
        String s = String.valueOf(a);
        char[] c = s.toCharArray();
        for(int i=c.length-1;i>=0;i--){
            sb.append(c[i]);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = Integer.parseInt(scanner.nextLine());
        m(i);
    }
}
