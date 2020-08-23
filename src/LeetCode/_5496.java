package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class _5496 {
    public static int maxCoins(int[] piles) {
        int res = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < piles.length; i++) {
            list.add(piles[i]);
        }
        Collections.sort(list);
        while (list.size()>0){
            res += list.get(list.size()-2);
            list.remove(list.size()-1);
            list.remove(list.size()-2);
            list.remove(0);
        }
        return res;
    }

    public static void main(String[] args) {
        int i = maxCoins(new int[]{9,8,7,6,5,1,2,3,4});
        System.out.println(i);
    }
}
