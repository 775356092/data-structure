package Number;

import java.util.Arrays;
import java.util.Scanner;

public class Asc_Desc {

    //升序降序
    public static void m(int x,int[] a){
        if(x==0){//升序
            Arrays.sort(a);
            for(int i=0;i<a.length;i++){
                if(i==a.length-1){
                    System.out.print(a[i]);
                    System.out.println();
                }else {
                    System.out.print(a[i]+" ");
                }
            }
        }else if(x==1){//降序
            Arrays.sort(a);
            StringBuilder sb = new StringBuilder();
            for(int i=a.length-1;i>=0;i--){
                if(i==0){
                    sb.append(a[i]);
                }else {
                    sb.append(a[i]);
                    sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = Integer.parseInt(scanner.nextLine());
            String[] s = scanner.nextLine().split(" ");
            int[] a= new int[n];
            for(int i = 0;i<n;i++){
                a[i] = Integer.parseInt(s[i]);
            }
            int m = Integer.parseInt(scanner.nextLine());
            m(m,a);
        }
    }
}
