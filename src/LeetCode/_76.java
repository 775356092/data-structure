package LeetCode;

import java.util.HashMap;

/**
 * @program: data-structure
 * @description: 最小覆盖子串
 * @author: wang hao
 * @create: 2020-05-23 16:12
 */
public class _76 {
    /**
     * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
     * 输入: S = "ADOBECODEBANC", T = "ABC"
     * 输出: "BANC"
     */
    //含泪超时
    /*public static String minWindows(String s, String t) {
        if (s.contains(t)) {
            return t;
        }
        int left = 0;
        int right = 0;
        int len = 9999999;
        int sl = 0;
        int sr = 0;
        if (t.length() > s.length()) {
            return "";
        }
        if (t.length() == s.length() && t.equals(s)) {
            return t;
        }
        if (t.length() == 1) {
            return s.contains(t) ? t : "";
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            set.add(t.charAt(i));
        }
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < t.length(); i++) {
            list.add(t.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            LinkedList<Character> characterss = new LinkedList<>(list);
            if (characterss.contains(l)) {
                left = i;
                characterss.remove((Object) l);
                for (int j = i + t.length() - 1; j < s.length(); j++) {
                    LinkedList<Character> characters = new LinkedList<>(characterss);
                    char r = s.charAt(j);
                    if (characters.contains(r)) {
                        right = j;
                        String temp = s.substring(left + 1, right);

                        if (temp.length() >= characters.size() - 1) {
                            characters.remove((Object) r);
                            *//*HashMap<Character, Integer> c = new HashMap<>();
                            for (int k = 0; k < temp.length(); k++) {
                                if (!c.containsKey(temp.charAt(k))) {
                                    c.put(temp.charAt(k), 1);
                                } else {
                                    c.put(temp.charAt(k), c.get(temp.charAt(k)) + 1);
                                }
                            }
                            HashMap<Character, Integer> v = new HashMap<>();
                            for (int k = 0; k < characters.size(); k++) {
                                if (!v.containsKey(characters.get(k))) {
                                    v.put(characters.get(k), 1);
                                } else {
                                    v.put(characters.get(k), v.get(characters.get(k)) + 1);
                                }
                            }
                            boolean flag = true;
                            for (Character x : v.keySet()) {
                                if (c.get(x) != null) {
                                    if (v.get(x) > c.get(x)) {
                                        flag = false;
                                        break;
                                    }
                                }else {
                                    flag = false;
                                    break;
                                }
                            }*//*
                            StringBuilder sb = new StringBuilder();
                            for (int m = 0; m < characters.size(); m++) {
                                sb.append(characters.get(m));
                            }
                            if (isContainsAll(temp, sb.toString()) && right - left + 1 <= len) {
                                len = right - left + 1;
                                sl = left;
                                sr = right;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return (sl == 0 && sr == 0) ? "" : s.substring(sl, sr + 1);
    }*/

    //含泪超时
    static HashMap<Character, Integer> c = new HashMap<>();
    static HashMap<Character, Integer> v = new HashMap<>();

    public static String minWindow(String s, String t) {
        if (s.contains(t)) {
            return t;
        }
        if (t.length() == 1) {
            return s.contains(t) ? t : "";
        }
        if (t.length() > s.length()) {
            return "";
        }
        if (t.length() == s.length() && t.equals(s)) {
            return t;
        }
        int len = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int l = 0;
        int r = 0;
        for (int k = 0; k < t.length(); k++) {
            if (!v.containsKey(t.charAt(k))) {
                v.put(t.charAt(k), 1);
            } else {
                v.put(t.charAt(k), v.get(t.charAt(k)).intValue() + 1);
            }
        }
        while (left < s.length()) {
            if (right == s.length() - 1) {
                break;
            }
            while (right < s.length()&&isContainsAll()) {
                if (!c.containsKey(s.charAt(right))) {
                    c.put(s.charAt(right), 1);
                } else {
                    c.put(s.charAt(right), c.get(s.charAt(right)).intValue() + 1);
                }
                if (!isContainsAll()) {
                    right++;
                } else {
                    break;
                }
            }
            if (right == s.length()) {
                break;
            }
            if (right - left + 1 <= len) {
                l = left;
                r = right;
                len = right - left + 1;
            }
            while (left < s.length() && left < right) {
                c.put(s.charAt(left), c.get(s.charAt(left)).intValue() - 1);
                left++;
                if (!isContainsAll()) {
                    left--;
                    break;
                }
            }
            if (right - left + 1 <= len) {
                l = left;
                r = right;
                len = right - left + 1;
            }
            left++;
        }
        return l == 0 && r == 0 ? "" : s.substring(l, r + 1);
    }

    /**
     * 判断字符串s是否包含t中所有的字符
     * 我想说的是 Java 用Map记录字母出现个数的写法，
     * 最后一个测试用例通不过时，要明白一件事。
     * Integer是对象啊。。。
     * Integer会缓存频繁使用的数值，
     * 数值范围为-128到127，在此范围内直接返回缓存值。
     * 超过该范围就会new 一个对象。
     * 浪费了我两个小时，希望有这种情况的老哥注意一下。
     *
     * @param
     * @param
     * @return
     */
    public static boolean isContainsAll() {
        boolean flag = true;
        for (Character x : v.keySet()) {
            if (c.get(x) != null) {
                if (v.get(x).intValue() > c.get(x).intValue()) {
                    flag = false;
                    break;
                }
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //ababc abba
    //bbaa aba
    //acbdbaab aabd
    //"adobecodebanc" "abcda" "adobecodeba"
    //"aabaabaaab" bb baab
    //"hwffmpuhbqftfeqfsyvwbrxwbgzalhfselzsctbdmgzrnpzfnwdonakoilrutwozjormjurvaspphouwkzmxczokkfgddvcplvdupussphhwxethdfgfeusrbyufvzugwzdmvvgkenhbtckzjqeqnyhoxbvscrbzqenmbtwfifiejudtkjjziqqhtlzwdcxtikhjfgqpnatxuwqfgbgqtwxmiyklbhgjtqvywlojmhiggynobweusbjcztpadwmwmhxkultgucpcceqgauatvlvxfnzkjlgxudhpqcxngmpltgrtctoafmxmzwwkkcheiqvystlbhdoajfwnaknfwktvjpftuozcevczoqcxtqyevurxgffdryaaoivkyvmdsqeiggfbwfhtbzqigvlxunakxxuwuibmafujnckjhscjturzqeymtywrwspscqfcxblkdwtlqxwlrpkjvkvolthjlwbnogqlibvnzqyrpwchlosgboxmhevvbwkrfcdpgachrdzizdrnukvvysjhxeeacprjtwyzxdhqgiyhlswhcsccklljrqlwhdfabgcyjjqprryejvmlnopzcajtsupzzxcbdgbmpudilbmwyajlryltawotqgusdytgewutqxddaqbzqkkhkxcltrgmzagczzkdxgzqdctfuxenhrwuqzhmsnyr"
    //"pgvofhuentu"
    public static void main(String[] args) {
        String s = minWindow("adobecodebanc", "abcda");
        System.out.println(s);
    }
}
