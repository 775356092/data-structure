package LeeCode;

/**
 * @program: data-structure
 * @description: 新21点
 * @author: wang hao
 * @create: 2020-06-03 14:23
 */
public class _837 {
    /**
     * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
     * <p>
     * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
     * <p>
     * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
     */

    //在最后一次抽牌之前，爱丽丝手上的牌至多为k-1分，再抽一张牌，在【1，w】之间抽牌
    //抽完爱丽丝手上的牌至少为k分，至多为k+w-1分，不少于k分的概率为1，大于k分的概率是0
    //dp[x]代表爱丽丝手上有x分，再抽一张牌停止抽牌且获胜的概率，题解是求dp[0]，所以定义一个数组dp，长度为k+w
    //dp[k-1] =1/w * ( dp[k] + dp[k+1] + dp[k+2] + ... + dp[k+w-1] )
    public static double new21Game(int N, int K, int W) {
        if (W <= 0) {
            return 0;
        }
        double dp[] = new double[K + W];
        for (int i = K; i < K + W; i++) {
            if (K <= N) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
            }
        }
        for (int i = K - 1; i >= 0; i--) {
            double x = 0;
            for (int j = 1; j <= W; j++) {
                x += dp[i + j];
            }
            dp[i] = ((double) (1 / W)) * x;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        double v = new21Game(21, 17, 10);
        System.out.println(v);
    }
}
