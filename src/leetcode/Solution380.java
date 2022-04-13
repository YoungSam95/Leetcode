package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 */
public class Solution380 {

    public class RandomizedSet {
        List<Integer> list;
        HashMap<Integer, Integer> valToIndex;
        Random random;
        public RandomizedSet() {
            list = new ArrayList<>();
            valToIndex = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(valToIndex.containsKey(val)){
                return false;
            }
            list.add(val);
            valToIndex.put(val, list.size()-1);
            return true;
        }

        public boolean remove(int val) {
            if(!valToIndex.containsKey(val)){
                return false;
            }
            int index = valToIndex.get(val);//要移除的目标的索引
            int last = list.get(list.size() - 1);//list最后一个元素
            list.set(index, last);
            list.remove(list.size() - 1);
            valToIndex.put(last, index);
            valToIndex.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
