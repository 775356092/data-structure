package LeeCode;

import java.util.Arrays;

public class _1356 {
    //1356. 根据数字二进制下 1 的数目排序
    //给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
    //如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
    //请你返回排序后的数组。
    public static String[] sortByBits(int[] arr) {
        String[] count = new String[]{"","","","","","","","","","","","","","","","","","","","","","","","","","","",""};
        int[] res = new int[arr.length];
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int t = 0;
            for(int j=31;j>=0;j--){
                if((arr[i]>>>j&1)==1){
                    t++;
                }
            }
            count[t]+="+"+(arr[i]);
        }
        int t = 0;
/*        for(int i=0;i<32;i++){
            if(t<arr.length){
                for(int j=0;j<count[i].length();j++){
                    res[t] = Integer.parseInt(count[i].substring(j,j+1));
                    t++;
                }
            }else {
                break;
            }
        }*/
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortByBits(new int[]{10,100,1000,1000,10000})));
    }
}
