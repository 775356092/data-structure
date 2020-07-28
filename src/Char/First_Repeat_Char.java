package Char;

import java.util.HashSet;

public class First_Repeat_Char {


    public static char FindFirstNonRepeatChar(char[] str) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length; i++) {
            set.add(str[i]);
        }

        for(Character c:set){
            int total = 0;
            for(int i=0;i<str.length;i++){
                if(c==str[i]){
                    total++;
                }
            }
            if(total==1){
                return c;
            }
        }
        return '0';
    }


    public static void main(String[] args) {
        char c = FindFirstNonRepeatChar(new char[]{'a', 'a', 'b', 'c', 'c'});
        System.out.println(c);
    }
}
