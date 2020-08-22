package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _679 {
    static int TARGET = 24;
    static double PRECISION = 1e-6;//精度

    public static boolean judgePoint24(int[] nums) {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add((double) nums[i]);
        }
        return judge(list);
    }

    public static boolean judge(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < PRECISION;
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    ArrayList<Double> list1 = new ArrayList<>();
                    for (int k = 0; k < list.size(); k++) {
                        if (k != i && k != j) {
                            list1.add(list.get(k));
                        }
                    }
                    double temp = 0;
                    double x = list.get(i);
                    double y = list.get(j);
                    for (int k = 0; k < 4; k++) {
                        //加法乘法不分次序
                        if (i > j && k < 2) {
                            continue;
                        }
                        if (k == 0) {
                            temp = x + y;
                        } else if (k == 1) {
                            temp = x * y;
                        } else if (k == 2) {
                            temp = x - y;
                        } else {
                            //除数不能为0
                            if (Math.abs(y) < PRECISION) {
                                continue;
                            } else {
                                temp = x / y;
                            }
                        }
                        list1.add(temp);
                        if (judge(list1)) {
                            return true;
                        } else {
                            list1.remove(list1.size() - 1);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean b = judgePoint24(new int[]{1, 2, 1, 2});
        System.out.println(b);
    }
}
