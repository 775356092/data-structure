package String;

import java.util.Scanner;

public class Hechang {
    //计算最少出列多少位同学，使得剩下的同学排成合唱队形
    //
    //说明：
    //
    //N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
    //合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，   则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
    //你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
    //8
    //186 186 150 200 160 130 197 200

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            int[] res1 = new int[n];
            int[] res2 = new int[n];
            int[] res = new int[n];
            for(int i=0;i<n;i++){
                int c = scanner.nextInt();
                a[i]=c;
                b[n-i-1]=c;
            }
            // 从左向右找当前位置以前的最大递增子序列个数
            for (int j=0;j<n;j++){
                res1[j]=1;
                for(int k=0;k<j;k++){
                    if(a[k]<a[j]&&res1[k]+1>res1[j]){
                        res1[j]=res1[k]+1;
                    }
                }
            }
            // 从右向坐找当前位置以后的最大递减子序列个数
            for (int j=n-1;j>=0;j--){
                res2[j]=1;
                for(int k=n-1;k>j;k--){
                    if(a[k]<a[j]&&res2[k]+1>res2[j]){
                        res2[j]=res2[k]+1;
                    }
                }
            }
            int max = 0;
            for (int j = 0;j<n;j++){
                res[j] = res1[j]+res2[j]-1;
                if(res[j]>max){
                    max=res[j];
                }
            }
            /*for (int j=0;j<n;j++){
                System.out.print(res1[j]+" ");
            }
            System.out.println();
            for (int j=0;j<n;j++){
                System.out.print(res2[j]+" ");
            }
            System.out.println();
            for (int j=0;j<n;j++){
                System.out.print(res[j]+" ");
            }
            System.out.println();*/
            System.out.println(n-max);
        }

    }
}
