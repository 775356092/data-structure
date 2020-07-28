package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 增减字符串匹配
 * @author: wang hao
 * @create: 2020-05-18 11:29
 */
public class _942 {
    /**
     * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
     * <p>
     * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
     * <p>
     * 如果 S[i] == "I"，那么 A[i] < A[i+1]
     * 如果 S[i] == "D"，那么 A[i] > A[i+1]
     */
    public static int[] diStringMatch(String S) {
        int len = S.length();
        int res[] = new int[len+1];
        int I = 0;
        int D = len;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == 'I') {
                res[i] = I;
                I++;
            } else {
                res[i] = D;
                D--;
            }
        }
        if(S.charAt(len-1)=='I'){
            res[len] = res[len-1]+1;
        }else {
            res[len] = res[len-1]-1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] idids = diStringMatch("DDI");
        System.out.println(Arrays.toString(idids));
    }

}
