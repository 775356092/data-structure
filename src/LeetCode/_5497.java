package LeetCode;

import java.util.ArrayList;

public class _5497 {

    //tle
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
            for (int j = y; j < temp.length(); j++) {
                if (j == temp.length() - 1 && temp.charAt(j) == '1') {
                    int count = 1;
                    if (count == m) {
                        res.add(i + 1);
                        break;
                    }
                    break;
                }
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
                j = y;
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

    //tle
    public static int findLatestStep2(int[] arr, int m) {
        if (m == arr.length) {
            return m;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append("1");
        }
        //11111
        for (int i = arr.length - 1; i > 0; i--) {
            int x = arr[i];
            sb.replace(x - 1, x, "0");
            String temp = new StringBuilder(sb).toString();
            int y = 0;
            for (int j = y; j < temp.length(); j++) {
                if (j == temp.length() - 1 && temp.charAt(j) == '1') {
                    if (m == 1) {
                        return i;
                    }
                    break;
                }
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
                j = y;
                if (count == m) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int latestStep = findLatestStep2(new int[]{2, 1}, 2);
        System.out.println(latestStep);
    }
}
