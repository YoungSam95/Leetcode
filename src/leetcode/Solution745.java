package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 745. 前缀和后缀搜索
 */
public class Solution745 {
    class WordFilter {

        private Map<String,Integer> map;

        public WordFilter(String[] words) {
            map = new HashMap<>();
            for(int i = 0; i < words.length; i++){
                int size = words[i].length();
                for(int prefSize = 1; prefSize <= size; prefSize++){
                    for(int suffSize = 1; suffSize <= size; suffSize++){
                        map.put(words[i].substring(0,prefSize) + "#" + words[i].substring(size - suffSize),i);
                    }
                }
            }
        }

        public int f(String pref, String suff) {
            return map.getOrDefault(pref + "#" + suff,-1);
        }
    }
}
