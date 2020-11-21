package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 根据身高重建队列
 * @author: wang hao
 * @create: 2020-11-16 09:16
 */
public class _406 {
    public int[][] reconstructQueue(int[][] people) {
        // 先按身高降序排，然后按照K个数升序排
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        ArrayList<int[]> list = new ArrayList<>();
        // 高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
        for (int[] arr : people) {
            list.add(arr[1], arr);
        }
        return list.toArray(people);
    }
}
