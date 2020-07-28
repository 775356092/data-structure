package String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IP_Count {
    static int A=0;
    static int B=0;
    static int C=0;
    static int D=0;
    static int E=0;
    static int F=0;
    static int P=0;
    // 输入 多行字符串。每行一个IP地址和掩码，用~隔开。
    // 统计A、B、C、D、E、错误IP地址或错误掩码、私有IP的个数，之间以空格隔开。


    //检查是否为合法的掩码
    public static boolean checkMask(String s){
        String[] split = s.split("\\.");
        if(Integer.parseInt(split[0])==255&&Integer.parseInt(split[1])==255&&Integer.parseInt(split[2])==255&&Integer.parseInt(split[3])==255){
            return false;
        }
        if(Integer.parseInt(split[0])==0&&Integer.parseInt(split[1])==0&&Integer.parseInt(split[2])==0&&Integer.parseInt(split[3])==0){
            return false;
        }
        int m = 0;
        for (int i=3;i>=0;i--){
            m+=(Integer.parseInt(split[i])<<((3-i)*8));//左移8位
        }
        m=~m+1;//取反加一
        if((m&(m-1))==0){//如果二进制数中只有一个1，即为2^n
            return true;
        }
        return false;
    }

    // 检查是否为合法的IP地址
    public static boolean checkIp(String ip){
        String[] s1 = ip.split("\\.");// 分割.符号
        if(s1.length==4&&!s1[0].equals("")&&!s1[1].equals("")&&!s1[2].equals("")&&!s1[3].equals("")){
            return true;
        }else {
            return false;
        }
        /*String str = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();*/
    }

    public static void m(String[] split,String[] s1){
        if(checkMask(split[1])){
            int c = Integer.parseInt(s1[0]);
            if(checkIp(split[0])){
                if (c>=1&&c<=126){
                    A++;
                    if (c==10){
                        P++;
                    }
                } else if (c>=128&&c<=191){
                    B++;
                    if (c==172&&Integer.parseInt(s1[1])>=16&&Integer.parseInt(s1[1])<=31){
                        P++;
                    }
                }else if (c>=192&&c<=223){
                    C++;
                    if (c==192&&Integer.parseInt(s1[1])==168){
                        P++;
                    }
                } else if (c>=224&&c<=239){
                    D++;
                }else if (c>=240&&c<=255){
                    E++;
                }
            }else {
                F++;
            }
        }else {
            F++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.isEmpty()){
                break;
            }
            String[] split = s.split("~");
            String[] s1 = split[0].split("\\.");
            m(split,s1);
        }
        System.out.println(A+" "+B+" "+C+" "+D+" "+E+" "+F+" "+P);
    }
}
