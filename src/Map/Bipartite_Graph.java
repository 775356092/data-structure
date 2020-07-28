package Map;

import java.util.Arrays;
import java.util.Scanner;

public class Bipartite_Graph {
    // 二分图的最大匹配 匈牙利算法
    // 6
    // 1 1
    // 1 2
    // 1 3
    // 2 1
    // 2 3
    // 3 1
    public static final int MAX = 999;
    public static int nx,ny;//nx表示二分图左边顶点的个数，ny表示二分图右边顶点的个数
    public static int x,y;//x点到y点有边
    public static int m;//m代表边的条数
    public static int[][] line = new int[MAX][MAX];//邻接矩阵
    public static int[] used = new int[MAX];//标记右边的顶点是否已经被匹配过了
    public static int[] nxt = new int[MAX];//标记右边匹配到的左边的顶点

    public static int match(){ //遍历左边的顶点找合适的右顶点
        int sum=0;
        for(int i=1;i<=nx;i++){
            Arrays.fill(used,0);//一定要清空used数组
            if(find(i)){sum++;}//找到合适的右顶点，结果加一
        }
        return sum;
    }

    public static boolean find(int x){// 根据左顶点找合适的右顶点
        for (int i=1;i<=ny;i++){
            if(line[x][i]==1&&used[i]==0){// 正好王八对绿豆，般配上了
                used[i]=1;
                if(nxt[i]==0||find(nxt[i])){// 如果右顶点之前没有匹配的左顶点，或者右顶点之前匹配的左顶点可以匹配到另外一个右顶点
                                            //（好比两男一女三角恋，男2和女1说我喜欢你，但是你有男朋友男1，你跟他分手，正好他也喜欢女2，女3
                                            // 你让男1去另外找一个
                    nxt[i]=x;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        nx = 3;
        ny = 3;
        for(int i=0;i<m;i++){
            x = scanner.nextInt();
            y = scanner.nextInt();
            line[x][y] = 1;
        }
        System.out.println(match());
    }
}
