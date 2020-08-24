package LeetCode;

/**
 * @description: 重复的子字符串
 * @author: wang hao
 * @create: 2020-08-24 09:15
 */
public class _459 {
    /**
     * 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
     */

    //假设原来的字符串为s，s'=s+s，如果s不能由它的一个子串多次重复构成，那么s'从下标1开始（不是第一个s），找s，它一定是第二个s
    //举个栗子：s:[abcd]，s':[abcd][abcd]
    //假设原来的字符串可以由子串多次重复构成，那么从下标1开始，在s’中找s，返回的下标必然是原来s中由子串第二次循环的开始下标
    //举个栗子：s:[ab][ab]，s':[ab][ab][ab][ab]
public static boolean repeatedSubstringPattern(String s) {
    return (s + s).indexOf(s, 1) != s.length();
}

    //枚举子字符串的长度
    //假设字符串s，由s'重复n次构成
    //子字符串s'一定要重复两次以上，所以子字符串的长度s'.len一定小于等于s.len/2
    //字符串的长度%子字符串的长度=0
    //在字符串中，从下标1开始，长度为s’.len的字符串s'，它的前缀也必然是s'，这就要求对应的字符一定是相等的
    //我们从一个字符开始枚举，假设[...]是遍历中的一个前缀，里面的...的个数代表的是i，从下一个[...]开始比较它之前的[...]每个字符是否一样
public static boolean repeatedSubstring(String s) {
    for (int i = 1; i * 2 <= s.length(); i++) {
        if (s.length() % i == 0) {
            boolean flag = true;
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
    }
    return false;
}

    public static void main(String[] args) {
        boolean abcabc = repeatedSubstringPattern("abc");
        System.out.println(abcabc);
    }
}
