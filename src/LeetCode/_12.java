package LeetCode;

import java.util.HashMap;

/**
 * @description: 整数转罗马数字
 * @author: wang hao
 * @create: 2020-09-07 16:39
 */
public class _12 {
/*    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MMM");
        map.put(0, "");
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int temp = (int) ((chars[i] - '0') * Math.pow(10, chars.length - i - 1));
            res.append(map.get(temp));
        }
        return res.toString();
    }*/

    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < 13) {
            while (num >= nums[index]) {
                res.append(romans[index]);
                num -= nums[index];
            }
            index++;
        }
        return res.toString();
    }
}
