package Number;

import java.util.Arrays;

public class Find_One {
    public static int find(int[] n){
        int res = 0;
        Arrays.sort(n);
        for(int i=0;i<n.length;i+=2){
            if(i==n.length-1){
                res = n[i];
                break;
            }
            if(n[i]!=n[i+1]){
                res = n[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{2,2,1,1,4,4,7,7,3}));
    }
}
