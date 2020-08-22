package String;


import java.util.Scanner;

public class merge {

    public static void sort(String s){
        StringBuilder sb = new StringBuilder(s);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i+=2){
            for(int j=i+2;j<s.length();j+=2){
                if(sb.charAt(i)>sb.charAt(j)){
                    char t=sb.charAt(j);
                    sb.replace(j,j+1,sb.charAt(i)+"");
                    sb.replace(i,i+1,t+"");
                }
            }
        }
        for(int i=1;i<s.length();i+=2){
            for(int j=i+2;j<s.length();j+=2){
                if(sb.charAt(i)>sb.charAt(j)){
                    char t=sb.charAt(j);
                    sb.replace(j,j+1,sb.charAt(i)+"");
                    sb.replace(i,i+1,t+"");
                }
            }
        }
        for(int i=0;i<s.length();i++){
            char x = sb.charAt(i);
            if((x<='f'&&x>='a')||(x>='0'&&x<='9')||(x>='A'&&x<='F')){
                char reverse = reverse(x);
                stringBuilder.append(reverse);
            }else {
                stringBuilder.append(x);
            }

        }
        System.out.println(stringBuilder.toString());
    }

    public static char reverse(char c){
        StringBuilder sb = new StringBuilder();
        int x = 0;
        //16进制字符转数字
        if(Character.isDigit(c)){
            x = Integer.parseInt(c+"");
        }else if(Character.isLowerCase(c)){
            x = 10+Integer.parseInt((char)(c-49)+"");
        }else if(Character.isUpperCase(c)){
            x = 10+Integer.parseInt((char)(c-17)+"");
        }
        //数字转16进制bytes
        int sum = 0;
        for(int m = 3;m >= 0; m--){
            sb.append(x >>> m & 1);
        }
        sb.reverse();
        for(int j=0;j<sb.length();j++){
            sum+=Math.pow(2,3-j)*Integer.parseInt(sb.charAt(j)+"");
        }
        if(sum<10){
            return (char)(sum+'0');
        }else if(sum==10){
            return 'A';
        } else if(sum==11){
            return 'B';
        } else if(sum==12){
            return 'C';
        }else if(sum==13){
            return 'D';
        }else if(sum==14){
            return 'E';
        }else if(sum==15){
            return 'F';
        }
        return 'a';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] s = scanner.nextLine().split(" ");
            String s1 = s[0];
            String s2 = s[1];
            String s3 = s1+s2;
            sort(s3);
        }
    }
}
