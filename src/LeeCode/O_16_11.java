package LeeCode;

import java.util.ArrayList;

/**
 * @description: 跳水板
 * @author: wang hao
 * @create: 2020-07-08 09:03
 */
public class O_16_11 {
    /**
     * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
     * <p>
     * 返回的长度需要从小到大排列。
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            int temp = shorter * (k - i);
            temp += longer * i;
            list.add(temp);
        }
        int res[] = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
