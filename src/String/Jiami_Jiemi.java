package String;

import java.util.Scanner;

public class Jiami_Jiemi {

    //加密
    static void Encrypt(char aucPassword[], char aucResult[]){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<aucPassword.length;i++){
            char c = aucPassword[i];
            if(Character.isUpperCase(c)){
                if(c=='Z'){
                    stringBuilder.append('a');
                }else {
                    stringBuilder.append((char)(c+33));
                }
            }else if (Character.isLowerCase(c)){
                if(c=='z'){
                    stringBuilder.append('A');
                }else {
                    stringBuilder.append((char)(c-31));
                }

            } else if(Character.isDigit(c)){
                if(c=='9'){
                    stringBuilder.append('0');
                }else {
                    stringBuilder.append((char)((int)(c)+1));
                }
            }else {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder.toString());
    }
    static void unEncrypt(char result[], char password[]){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<password.length;i++){
            char c = password[i];
            if(Character.isUpperCase(c)){
                if(c=='A'){
                    stringBuilder.append('z');
                }else {
                    stringBuilder.append((char)(c+31));
                }
            }else if (Character.isLowerCase(c)){
                if(c=='a'){
                    stringBuilder.append('Z');
                }else {
                    stringBuilder.append((char)(c-33));
                }
            } else if(Character.isDigit(c)){
                if(c=='0'){
                    stringBuilder.append('9');
                }else {
                    stringBuilder.append((char)((int)(c)-1));
                }
            }else {
                stringBuilder.append(c);
            }
        }
        System.out.println(stringBuilder.toString());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            Encrypt(s1.toCharArray(),new StringBuilder().toString().toCharArray());
            unEncrypt(new StringBuilder().toString().toCharArray(),s2.toCharArray());
        }
    }
}
