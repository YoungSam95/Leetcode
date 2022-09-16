package leetcode;

import java.util.Arrays;

/**
 * 1624. 两个相同字符之间的最长子字符串
 */
public class Solution1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        char[] cs = s.toCharArray();
        for(int i = 0; i < cs.length; i++){
            for(int j = cs.length - 1; j > i; j--){
                if(cs[i] == cs[j]){
                    res = Math.max(res,j - i - 1);
                    break;
                }
            }
        }
        return res;
    }
    public int maxLengthBetweenEqualCharacters1(String s) {
        char c[] = s.toCharArray();
        int idx[] = new int[26];
        Arrays.fill(idx,-1);
        int res=-1;
        for(int i = 0; i < c.length; i++){
            int index = c[i] - 'a';
            if(idx[index ]== -1) {
                idx[index] = i;
            } else{
                res = Math.max(res,i - idx[index] - 1);
            }
        }
        return res;
    }
}
