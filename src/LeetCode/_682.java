package LeetCode;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @description: 棒球比赛
 * @author: wang hao
 * @create: 2020-09-18 15:10
 */
public class _682 {
    public int calPoints(String[] ops) {
        int res = 0;
        ArrayList<Integer> scores = new ArrayList<>();
        for (String s : ops) {
            int score = 0;
            boolean flag = false;
            if (s.equals("+")) {
                score = scores.get(scores.size() - 1) + scores.get(scores.size() - 2);
            } else if (s.equals("D")) {
                score = scores.get(scores.size() - 1) * 2;
            } else if (s.equals("C")) {
                flag = true;
                score = -(scores.get(scores.size() - 1));
            } else {
                score = Integer.parseInt(s);
            }
            res += score;
            if (!flag) {
                scores.add(score);
            } else {
                scores.remove(scores.size() - 1);
            }
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }
}
