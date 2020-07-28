package Number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class No_Repeat {
    // 一个数从右向左统计不重复的数字输出
    // 输入 2373928
    // 输出 82937

    public static void convert(int n){
        HashMap m = new HashMap<>();
        ArrayList l = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (n>0){
            if(!m.containsKey(n%10)){
                m.put(n%10,0);
                l.add(n%10);
            }
            n/=10;
        }

        for (Object o:l){
            sb.append(o);
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        convert(n);
    }
}
