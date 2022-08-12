package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1282. 用户分组
 */
public class Solution1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int[] flag = new int[groupSizes.length];
        for(int i = 0; i < groupSizes.length; i++){
            if(flag[i] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                flag[i] = 1;
                int size = groupSizes[i];
                if (size > 1) {
                    int currSize = 1;
                    for (int j = i + 1; j < groupSizes.length; j++) {
                        if (currSize < size && groupSizes[j] == size && flag[j] == 0) {
                            list.add(j);
                            currSize++;
                            flag[j] = 1;
                        }
                    }
                }
                res.add(list);
            }
        }
        return res;
    }
    public List<List<Integer>> groupThePeople2(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < groupSizes.length; i++){
            List<Integer> list = map.getOrDefault(groupSizes[i],new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i],list);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int k : map.keySet()){
            List<Integer> list = map.get(k);
            List<Integer> group = new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                group.add(list.get(i));
                if(group.size() == k){
                    res.add(group);
                    group = new ArrayList<>();
                }
            }
        }
        return res;
    }
    public List<List<Integer>> groupThePeople3(int[] groupSizes) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = groupSizes.length;
        for(int i = 0; i < len; i++){
            int size = groupSizes[i];
            map.putIfAbsent(size,new ArrayList<>());
            map.get(size).add(i);
            if(map.get(size).size() == size){
                res.add(map.get(size));
                map.put(size,new ArrayList<>());
            }
        }
        return res;
    }
}
