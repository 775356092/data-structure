package String;

import java.math.BigInteger;
import java.util.Scanner;


public class Sixteen_2_Ten {
    // 十六进制字符串转换成十进制字符串
    public static int covert(String s){
        if(s.equals("0")){return 0;}
        else if(s.equals("1")){return 1;}
        else if(s.equals("2")){return 2;}
        else if(s.equals("3")){return 3;}
        else if(s.equals("4")){return 4;}
        else if(s.equals("5")){return 5;}
        else if(s.equals("6")){return 6;}
        else if(s.equals("7")){return 7;}
        else if(s.equals("8")){return 8;}
        else if(s.equals("9")){return 9;}
        else if(s.equals("A")){return 10;}
        else if(s.equals("B")){return 11;}
        else if(s.equals("C")){return 12;}
        else if(s.equals("D")){return 13;}
        else if(s.equals("E")){return 14;}
        else if(s.equals("F")){return 15;}
        return 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int num = 0;
            String res=null;
            String s = scanner.nextLine();
            for (int i =2;i<s.length();i++){
                String s1 = s.substring(i,i+1);
                int ss1 = covert(s1.toUpperCase());
                num+=(int) ((int)ss1*Math.pow(16,s.length()-i-1));
            }
            Integer integer = new Integer(num);
            res = Integer.toString(integer);
            System.out.println(res);
        }
    }
}
