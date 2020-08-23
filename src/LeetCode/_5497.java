package LeetCode;

import java.util.ArrayList;

public class _5497 {

    public static int findLatestStep(int[] arr, int m) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            sb.append("0");
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            sb.replace(x - 1, x, "1");
            String temp = new StringBuilder(sb).toString();
            int y = 0;
            while (y!=temp.length()-1){

            }
            for (int j = y; j < temp.length() - 1; j++) {
                if (temp.charAt(j) == '0') {
                    continue;
                }
                int count = 1;
                for (int k = j + 1; k < temp.length(); k++) {
                    y = k;
                    if (temp.charAt(k) == '1') {
                        count++;
                    } else {
                        break;
                    }
                }
                j = y - 1;
                if (count == m) {
                    res.add(i + 1);
                    break;
                }
            }
        }
        if (res.size() == 0) {
            return -1;
        }
        return res.get(res.size() - 1);
    }

    public static void main(String[] args) {
        int latestStep = findLatestStep(new int[]{3, 5, 1, 2, 4}, 1);
        System.out.println(latestStep);
    }
}
