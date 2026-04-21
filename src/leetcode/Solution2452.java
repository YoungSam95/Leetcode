package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2452. 距离字典两次编辑以内的单词
 */
public class Solution2452 {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            for (String s : dictionary) {
                int dis = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        dis++;
                    }
                }
                if (dis <= 2) {
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;
    }
}
