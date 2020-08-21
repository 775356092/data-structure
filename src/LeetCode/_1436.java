package LeetCode;

import java.util.HashMap;
import java.util.List;

/**
 * @program: data-structure
 * @description: 旅行终点站
 * @author: wang hao
 * @create: 2020-05-12 11:04
 */
public class _1436 {
    /**
     * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
     *
     * 题目数据保证线路图会形成一条不存在循环的线路，因此只会有一个旅行终点站。
     */
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();
        for(List<String> list:paths){
            map.put(list.get(0),list.get(1));
        }
        String from =  paths.get(0).get(0);
        while(true){
            if(!map.containsKey(from)){
                return from;
            }
            from = map.get(from);
        }
    }
}
