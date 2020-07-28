package LeeCode;

import java.util.HashMap;

/**
 * @program: data-structure
 * @description: 和可被 K 整除的子数组
 * @author: wang hao
 * @create: 2020-05-27 10:24
 */
public class _974 {
    /**
     * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
     */
    //前缀和 sum[i,j] = preSum[j]-preSum[i-1]
    //sum[i,j]%K==0  ==> preSum[j] mod K = preSum[i-1] mod K
    public static int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        //preSum[j] mod K = preSum[i-1] mod K
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            //当被除数为负数时取模结果为负数，需要纠正
            int temp = (sum % K + K) % K;
            if (!map.containsKey(temp)) {
                map.put(temp, 1);
            } else {
                map.put(temp, map.get(temp).intValue() + 1);
            }
        }
        for (Integer i : map.keySet()) {
            res += map.get(i).intValue() * (map.get(i).intValue() - 1) / 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = subarraysDivByK(new int[]{4, 5, 0, -2, -3, 1}, 5);
        System.out.println(i);
    }
}
