package LeeCode;

import java.util.HashMap;
import java.util.Set;

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

    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.replace(nums[i], map.get(nums[i]) + 1);
            }
        }
        for(Integer i : map.keySet()){
            if(map.get(i)==1){
                res = i;
                break;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = singleNumber(new int[]{2, 2, 1});
        System.out.println(i);
    }
}
