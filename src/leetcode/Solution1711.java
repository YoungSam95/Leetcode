package leetcode;

/**
 * 面试题 17.11. 单词距离
 */
public class Solution1711 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = words.length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0) {
                res = Math.min(res, Math.abs(index1 - index2));
            }
        }
        return res;
    }
}
