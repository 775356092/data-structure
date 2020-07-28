package String;

import java.util.Scanner;

public class Palindromic_String_Max {

    //求字符串中最大回文字符串的长度
    public static String m(String s) {
        int begin = 0;
        int end = 0;
        int len = s.length();
        int max = 1;
        if (len <= 1) {
            return s;
        }
        for (int i = 1; i < len; i++) {
            //找以i，i-1为中心的偶数回文子序列
            int low = i - 1;
            int high = i;
            while (high < len && low >= 0 && s.charAt(high) == s.charAt(low)) {
                low--;
                high++;
            }
            if (high - low - 1 > max) {
                max = high - low - 1;
                begin = low + 1;
                end = high;
            }
            //找以i-1，i+1为中心的奇数回文子序列
            low = i - 1;
            high = i + 1;
            while (high < len && low >= 0 && s.charAt(high) == s.charAt(low)) {
                low--;
                high++;

            }
            if (high - low - 1 > max) {
                max = high - low - 1;
                begin = low + 1;
                end = high;

            }

        }
        return s.substring(begin, end);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            System.out.println(m(s));
        }
    }
}
