package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @description: 罗马数字转整数
 * @author: wang hao
 * @create: 2020-09-07 15:59
 */
public class _13 {
    public int romanToInt(String s) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>(){};
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                res += map.get(chars[i]);
            } else {
                int x = map.get(chars[i]);
                int y = map.get(chars[i + 1]);
                if (y > x) {
                    res += (y - x);
                    i++;
                } else {
                    res += x;
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(romanToInt("IV"));
    }
}
