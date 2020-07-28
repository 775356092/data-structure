package Number;

import java.util.Scanner;

public class Ball_Fall_Height {
    //假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
    //
    //最后的误差判断是小数点3位
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            float a = (float) n/2;
            float b = (float) n/2/2;
            float c = (float) n/2/2/2;
            float d = (float) n/2/2/2/2/2;
            System.out.println(n*2+a+b+c);
            System.out.println(d);
        }
    }
}
