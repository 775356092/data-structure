package String;


import java.util.Scanner;

public class Password_Transfer {

    //密码转换
    public static void m(String s){
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                if(c=='Z'){
                    sb.append('a');
                }else {
                    c+=33;
                    sb.append(c);
                }
            }else if(Character.isLowerCase(c)){
                if (c>=97&&c<=99){//abc
                    sb.append('2');
                }else if(c>=100&&c<=102){//def
                    sb.append('3');
                }else if(c>=103&&c<=105){//ghi
                    sb.append('4');
                }else if(c>=106&&c<=108){//jkl
                    sb.append('5');
                }else if(c>=109&&c<=111){//mno
                    sb.append('6');
                }else if(c>=112&&c<=115){//pqrs
                    sb.append('7');
                }else if(c>=116&&c<=118){//tuv
                    sb.append('8');
                }else if(c>=119&&c<=122){//wxyz
                    sb.append('9');
                }
            }else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
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
