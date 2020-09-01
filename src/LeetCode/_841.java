package LeetCode;

import java.util.*;

public class _841 {
    //841. 钥匙和房间有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
    //在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
    //最初，除 0 号房间外的其余所有房间都被锁住。
    //你可以自由地在房间之间来回走动。
    //如果能进入每个房间返回 true，否则返回 false。
    int count;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        dfs(rooms, 0, visited);
        return count == rooms.size();
    }

    public void dfs(List<List<Integer>> rooms, int room, int[] visited) {
        visited[room]++;
        count++;
        for (int next : rooms.get(room)) {
            if (visited[next] == 0) {
                dfs(rooms, next, visited);
            }
        }
    }

    //bfs
    public boolean canVisitAllRoom(List<List<Integer>> rooms) {
        int[] visited = new int[rooms.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0]++;
        while (!queue.isEmpty()) {
            int room = queue.poll();
            count++;
            for (int next : rooms.get(room)) {
                if (visited[next] == 0) {
                    visited[next]++;
                    queue.offer(next);
                }
            }
        }
        return count == rooms.size();
    }

}
