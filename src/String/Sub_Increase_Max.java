package String;

import java.util.Scanner;

public class Sub_Increase_Max {

    //最长递增子序列的个数
    public static void m(int[] a){
        int[] res = new int[a.length];
        for(int i=0;i<a.length;i++){
            res[i]=1;
            for(int j=0;j<i;j++){
                if(a[j]<a[i]&&res[j]+1>res[i]){
                    res[i] = res[j]+1;
                }
            }
        }
        int max = 0;
        for(int i=0;i<res.length;i++){
            if(res[i]>max){
                max = res[i];
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            for(int i=0;i<n;i++){
                a[i] = scanner.nextInt();
            }
            m(a);
        }
    }
}
