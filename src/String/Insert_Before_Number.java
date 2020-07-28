package String;

import java.util.Scanner;

public class Insert_Before_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s= scanner.nextLine();
            StringBuilder sb = new StringBuilder(s);
            for(int i=0;i<sb.length()-1;i++){
                if((Character.isLetter(sb.charAt(i))&&Character.isDigit(sb.charAt(i+1)))||(Character.isDigit(sb.charAt(i))&&Character.isLetter(sb.charAt(i+1)))){
                    sb.insert(i+1,"*");
                }
            }
            if(Character.isDigit(sb.charAt(0))){
                sb.insert(0,"*");
            }
            if(Character.isDigit(sb.charAt(sb.length()-1))){
                sb.insert(sb.length(),"*");
            }
            System.out.println(sb.toString());
        }
    }
}
