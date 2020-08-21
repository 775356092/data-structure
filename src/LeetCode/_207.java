package LeetCode;

import java.util.LinkedList;

/**
 * @description: 课程表
 * @author: wang hao
 * @create: 2020-08-04 08:55
 */
public class _207 {
    /**
     * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
     *
     * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
     *
     * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) {
            return false;
        }
        int inDegree[] = new int[numCourses];
        //初始化入度数组
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
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
        return numCourses == cnt;
    }
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
}
