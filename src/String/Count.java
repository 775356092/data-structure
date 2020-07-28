package String;

import java.util.Calendar;
import java.util.Scanner;

public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;
            String s = scanner.nextLine();
            for(int i=0;i<s.length();i++){
                if(Character.isLetter(s.charAt(i))){
                    a++;
                }else if(s.charAt(i)==' '){
                    b++;
                }else if(Character.isDigit(s.charAt(i))){
                    c++;
                }else {
                    d++;
                }
            }
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
        }
    }
}
