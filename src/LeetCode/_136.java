package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @program: data-structure
 * @description: 只出现一次的数字
 * @author: wang hao
 * @create: 2020-05-14 08:51
 */
public class _136 {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    //hash表
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

    //异或运算满足交换律和结合律 a^a = 0, a^0 = a, a^b^a = a^a^b = 0^b = b
    public int singleNumber2(int[] nums) {
        int t = 0;
        for (int n : nums) {
            t ^= n;
        }
        return t;
    }

    @Test
    public void test() {
        System.out.println(singleNumber(new int[]{1, 1, 2, 2, 3}));
    }
}
