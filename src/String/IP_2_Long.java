package String;

import java.util.Scanner;

public class IP_2_Long {

    //ip地址转数字
    public static long ip_int(String s){
        long sum=0;
        String[] split = s.split("\\.");
        sum=(Long.parseLong(split[0])<<24|Long.parseLong(split[1])<<16|Long.parseLong(split[2])<<8)|Long.parseLong(split[3]);
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            String s1 =scanner.nextLine();
            long i = Long.parseLong(s1);
            System.out.println(ip_int(s));
            int[] ip = new int[4];
            ip[0] = (int) ((i&0xff000000)>>24);
            ip[1] = (int) ((i&0x00ff0000)>>16);
            ip[2] = (int) ((i&0x0000ff00)>>8);
            ip[3] = (int) (i&0x000000ff);
            System.out.println(ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3]);
        }
    }
}
