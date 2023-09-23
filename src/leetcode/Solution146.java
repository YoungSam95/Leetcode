package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 146. LRU 缓存
 * 第二次
 */
public class Solution146 {

    class LRUCache {
        int capacity;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if(!cache.containsKey(key)) return -1;
            //将key变为最近使用
            makeRecently(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if(cache.containsKey(key)){
                //修改value
                cache.put(key,value);
                //将key设为最近使用
                makeRecently(key);
                return;
            }
            if(cache.size() >= this.capacity){
                //链表头部就是最久未使用
                int oldestKey = cache.keySet().iterator().next();
                cache.remove(oldestKey);
            }
            //添加新的key
            cache.put(key,value);
        }

        public void makeRecently(int key){
            int value = cache.get(key);
            //删除以前的，当前加入队尾
            cache.remove(key);
            cache.put(key,value);
        }
    }
}
