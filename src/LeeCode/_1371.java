package LeeCode;

import java.util.Arrays;

/**
 * @program: data-structure
 * @description: 每个元音包含偶数次的最长子字符串
 * @author: wang hao
 * @create: 2020-05-20 08:53
 */
public class _1371 {
    /**
     * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
     */
    //uoiea5个元音字符的奇偶状态可以用二进制数表示
    //uoiea-->00001,意思是a出现了奇数次，其它数出现的次数为偶数次
    //uoiea-->11111,意思是所有元音字符都出现了奇数次
    //uoiea-->00000,意思是所有元音字符都出现了偶数次
    //一共有32种状态，我们在遍历字符串的时候，用数组更新每次遍历aeiou出现奇、偶次数的状态
    public static int findTheLongestSubstring(String s) {
        int res = 0;
        int pos[] = new int[1 << 5];
        Arrays.fill(pos, -1);
        int status = 0;
        pos[0] = 0;

        //枚举每个字符，找以它结尾的满足条件的最大字符串长度
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                status ^= 1 << 0;
            } else if (s.charAt(i) == 'e') {
                status ^= 1 << 1;
            } else if (s.charAt(i) == 'i') {
                status ^= 1 << 2;
            } else if (s.charAt(i) == 'o') {
                status ^= 1 << 3;
            } else if (s.charAt(i) == 'u') {
                status ^= 1 << 4;
            }

            //此状态在之前的遍历中有没有出现过
            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int eleetminicoworoep = findTheLongestSubstring("abc");
        System.out.println(eleetminicoworoep);
    }
}
