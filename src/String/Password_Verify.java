package String;

import org.junit.Test;

import java.util.Scanner;

public class Password_Verify {

    // 验证简单密码
    public static void m(String s) {
        int a = 0, b = 0, c = 0, d = 0;
        if (s.length() <= 8) {
            System.out.println("NG");
            return;
        } else {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isDigit(chars[i])) {//数字
                    a=1;
                } else if (Character.isUpperCase(chars[i])) {//大写
                    b=1;
                } else if (Character.isLowerCase(chars[i])) {//小写
                    c=1;
                } else {//其他
                    d=1;
                }
            }
            if(a+b+c+d>=3){
                if(!isContainSubStr(s)){
                    System.out.println("OK");
                    return;
                }else {
                    System.out.println("NG");
                    return;
                }
            }else {
                System.out.println("NG");
                return;
            }
        }
    }


    // 是否有相同长度超2的子串重复
    public static boolean isContainSubStr(String s){
        for (int i=0;i<s.length()-3;i++){
            String s1 = s.substring(i,i+3);
            String s2 = s.substring(i+3,s.length());
            if(s2.contains(s1)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (s.isEmpty()) {
                break;
            }
            m(s);
        }
    }
}
