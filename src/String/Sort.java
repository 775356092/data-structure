package String;

import java.util.Scanner;

public class Sort {
    //编写一个程序，将输入字符串中的字符按如下规则排序。
    //
    //规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
    //
    //如，输入： Type 输出： epTy
    //
    //规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
    //
    //如，输入： BabA 输出： aABb
    //
    //规则 3 ：非英文字母的其它字符保持原来的位置。
    //
    //
    //如，输入： By?e 输出： Be?y
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            StringBuilder sb = new StringBuilder();
            String s = scanner.nextLine();
            for(int j=0;j<26;j++){
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)==(char) ('a'+j)||s.charAt(i)==(char) ('A'+j)){
                        sb.append(s.charAt(i));
                    }
                }
            }
            for(int i=0;i<s.length();i++){
                char c = s.charAt(i);
                if(!Character.isLetter(c)){
                    sb.insert(i,s.charAt(i));
                }
            }
            System.out.println(sb.toString());
        }
    }
}
