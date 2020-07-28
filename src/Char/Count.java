package Char;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count {
    //对字符中的
    //各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。
    //aadddccddc
    //dca

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String buf = in.next();
            Map<Character, Integer> map = new HashMap<Character, Integer>(127);
            for(int i = 0; i < buf.length(); i++) {
                char cc = buf.charAt(i);
                if(!map.containsKey(cc)) {
                    map.put(cc, 1);
                } else {
                    map.put(cc, map.get(cc) + 1);
                }
            }
            Map<Integer, Character> treeMap = new TreeMap<Integer, Character>();
            for(char cc : map.keySet()) {
                treeMap.put(map.get(cc)*128 + 128 - cc, cc);
            }
            StringBuilder res = new StringBuilder();
            for(int times : treeMap.keySet()) {
                res.append(treeMap.get(times));
            }
            System.out.println(res.reverse().toString());
        }
    }
}
