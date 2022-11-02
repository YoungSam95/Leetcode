package leetcode;

/**
 * 1668. 最大重复子字符串
 */
public class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        String s=word;
        int ans=0;
        while(sequence.contains(s)){
            ans++;
            s+=word;
        }
        return ans;
    }
}
