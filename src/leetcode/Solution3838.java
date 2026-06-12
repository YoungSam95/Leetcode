package leetcode;

/**
 * 3838. 带权单词映射
 */
public class Solution3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder(words.length);
        for (String word : words) {
            int s = 0;
            for (int i = 0; i < word.length(); i++) {
                s += weights[word.charAt(i) - 'a'];
            }
            ans.append((char) ('z' - s % 26));
        }
        return ans.toString();
    }
}
