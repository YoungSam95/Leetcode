package leetcode;

/**
 * 2255. 统计是给定字符串前缀的字符串数目
 */
public class Solution2255 {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                res++;
            }
        }
        return res;
    }
}
