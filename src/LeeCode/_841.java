package LeeCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _841 {
    //841. 钥匙和房间有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
    //在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
    //最初，除 0 号房间外的其余所有房间都被锁住。
    //你可以自由地在房间之间来回走动。
    //如果能进入每个房间返回 true，否则返回 false。
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int roomCount = rooms.size();
        if (roomCount <= 1) {
            return true;
        }
        boolean[] visited = new boolean[roomCount];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int key = queue.poll();
                List<Integer> nexts = rooms.get(key);
                for (Integer next : nexts) {
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
        }
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

}
