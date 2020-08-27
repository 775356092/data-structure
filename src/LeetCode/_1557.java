package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: wang hao
 * @create: 2020-08-27 13:43
 */
public class _1557 {
    //入度为0 的节点
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] inDegree = new int[n];
        for (List<Integer> list : edges) {
            inDegree[list.get(1)]++;
        }
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                res.add(i);
            }
        }
        return res;
    }

}
