package LeeCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @program: data-structure
 * @description: 唯一摩尔斯密码词
 * @author: wang hao
 * @create: 2020-05-12 15:10
 */
public class _804 {
    /**
     * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
     * <p>
     * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
     * <p>
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
     * <p>
     * 返回我们可以获得所有词不同单词翻译的数量。
     */

    public int uniqueMorseRepresentations(String[] words) {
        HashMap<Character, String> map = new HashMap<>();
        String[] arr = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        for (int i = 0; i < arr.length; i++) {
            char c = (char) ('a' + i);
            map.put(c, arr[i]);
        }
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<words[i].length();j++){
                sb.append(map.get(words[i].charAt(j)));
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
