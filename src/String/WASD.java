package String;

import java.util.Scanner;

public class WASD {
    // 坐标移动
    public static void m(String[] s) {
        int x = 0;
        int y = 0;
        int l = s.length;
        for (int i = 0; i < l; i++) {
            if(s[i].toCharArray()[0] == 'W'){
                if(s[i].toCharArray().length==2){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        int c = s[i].toCharArray()[1]-'0';
                        y+=c;
                    }

                }else if(s[i].toCharArray().length==3){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        if(Character.isDigit(s[i].toCharArray()[2])){
                            int c = (s[i].toCharArray()[1]-'0')*10+s[i].toCharArray()[2]-'0';
                            y+=c;
                        }
                    }

                }
            }else if(s[i].toCharArray()[0] == 'A'){
                if(s[i].toCharArray().length==2){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        int c = s[i].toCharArray()[1]-'0';
                        x-=c;
                    }

                }else if(s[i].toCharArray().length==3){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        if(Character.isDigit(s[i].toCharArray()[2])){
                            int c = (s[i].toCharArray()[1]-'0')*10+s[i].toCharArray()[2]-'0';
                            x-=c;
                        }
                    }

                }
            }else if(s[i].toCharArray()[0] == 'S'){
                if(s[i].toCharArray().length==2){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        int c = s[i].toCharArray()[1]-'0';
                        y-=c;
                    }

                }else if(s[i].toCharArray().length==3){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        if(Character.isDigit(s[i].toCharArray()[2])){
                            int c = (s[i].toCharArray()[1]-'0')*10+s[i].toCharArray()[2]-'0';
                            y-=c;
                        }
                    }

                }
            }else if(s[i].toCharArray()[0] == 'D'){
                if(s[i].toCharArray().length==2){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        int c = s[i].toCharArray()[1]-'0';
                        x+=c;
                    }

                }else if(s[i].toCharArray().length==3){
                    if(Character.isDigit(s[i].toCharArray()[1])){
                        if(Character.isDigit(s[i].toCharArray()[2])){
                            int c = (s[i].toCharArray()[1]-'0')*10+s[i].toCharArray()[2]-'0';
                            x+=c;
                        }
                    }
                }
            }

        }
        System.out.println(x+","+y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] s = scanner.nextLine().split(";+");//分割多个加号
            m(s);
        }
    }
}
