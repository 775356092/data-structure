package LeeCode;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: data-structure
 * @description: 课程表 II
 * @author: wang hao
 * @create: 2020-05-17 17:25
 */
public class _210 {
    /**
     * 现在你总共有 n 门课需要选，记为 0 到 n-1。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
     * <p>
     * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
     * <p>
     * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
     */

    //bfs,有向图的拓扑排序
    /*public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return new int[0];
        }
        int inDegree[] = new int[numCourses];
        //初始化入度数组
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        int res[] = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                //入度为0入队
                queue.add(i);
            }
        }
        int cnt = 0;
        while (!queue.isEmpty()) {
            //入度为0的出队
            int x = queue.poll();
            res[cnt] = x;
            cnt++;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == x) {
                    //出队的邻接节点度减一
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        //入度为0的入队
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        return numCourses == cnt ? res : new int[0];
    }*/

    //dfs
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int res[] = new int[numCourses];
        int cnt = 0;
        if (numCourses == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        int flag[] = new int[numCourses];


        return cnt == numCourses ? res : new int[0];
    }

    public Stack<Integer> dfs(Stack<Integer> stack,int[] flag,int[][] prerequisites){
        return null;
    }
}
