package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1408. 数组中的字符串匹配
 */
public class Solution1408 {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words.length; j++){
                if(words[j].contains(words[i]) && !words[j].equals(words[i])){
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }
}
