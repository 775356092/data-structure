package Number;

import java.util.Scanner;

public class Rabbit {

    //有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int a = 0;//成熟的兔子
            int b = 0;//差一个月成熟的兔子
            int c = 1;//差两个月成熟的兔子
            for(int i=1;i<n;i++){
                a+=b;
                b=c;
                c=a;
            }
            System.out.println(a+b+c);
        }
    }
}
