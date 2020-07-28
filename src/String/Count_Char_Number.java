package String;

import java.util.Scanner;

public class Count_Char_Number {
    // 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
    // 输出输入字符串中含有该字符的个数。
    // 输入 ABCDEF
    //     A
    // 输出1
    public static void length(String s,String c){
        String s1 = s.toLowerCase();
        char[] ss1 = s1.toCharArray();
        String s2 = c.toLowerCase();
        char[] ss2 = s2.toCharArray();
        int count = 0;
        for(int i = 0; i< s.length();i++){
            if(ss1[i]==ss2[0]){
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String c = scanner.nextLine();
        length(s,c);
    }
}
