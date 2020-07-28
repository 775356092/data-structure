package String;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Classify {
    //﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I<j>：
    //
    //I<j>整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I<j>为231，那么I<j>包含了R<i>，条件满足 。
    //
    //按R<i>从小到大的顺序:
    //
    //(1)先输出R<i>；
    //
    //(2)再输出满足条件的I<j>的个数；
    //
    //(3)然后输出满足条件的I<j>在I序列中的位置索引(从0开始)；
    //
    //(4)最后再输出I<j>。
    //
    //附加条件：
    //
    //(1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I<j>，索引大的需要过滤掉
    //
    //(2)如果没有满足条件的I<j>，对应的R<i>不用输出
    //
    //(3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
    //
    //
    //
    //序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
    //
    //序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
    //
    //输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
    //
    //说明：
    //
    //30----后续有30个整数
    //
    //3----从小到大排序，第一个R<i>为0，但没有满足条件的I<j>，不输出0，而下一个R<i>是3
    //
    //6--- 存在6个包含3的I<j>
    //
    //0--- 123所在的原序号为0
    //
    //123--- 123包含3，满足条件
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            TreeSet<Object> set = new TreeSet<>();
            ArrayList<String> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();
            String[] s1 = scanner.nextLine().split(" ");
            String[] s2 = scanner.nextLine().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s2[0]);
            for (int i=1;i<=n;i++){
                list1.add(s1[i]);
            }
            for(int i=1;i<=m;i++){
                set.add(s2[i]);
            }
            for (Object o:set){
                list2.add(Integer.parseInt(o+""));
            }
            Collections.sort(list2);
        /*for (Object o:list1){
            System.out.print(o+" ");
        }
        System.out.println();
        for (Object o:list2){
            System.out.print(o+" ");
        }
        System.out.println();*/
            int count=0;
            ArrayList<Integer> res = new ArrayList<>();
            res.add(count);
            for(int i=0;i<list2.size();i++){
                int temp=0;
                HashMap<Integer, Integer> map = new LinkedHashMap<>();
                for (int j=0;j<n;j++){
                    if(list1.get(j).contains(list2.get(i)+"")){
                        temp++;
                        map.put(j,Integer.parseInt(list1.get(j)));
                    }
                }
                if(temp!=0){
                    res.add((list2.get(i)));
                    res.add(temp);
                }
                for(Integer x:map.keySet()){
                    res.add(x);
                    res.add(map.get(x));
                }
            }
            res.set(0,res.size()-1);
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }

    }
}
