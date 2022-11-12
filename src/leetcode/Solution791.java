package leetcode;

/**
 * 791. 自定义字符串排序
 */
public class Solution791 {
    public String customSortString(String order, String s) {
        int[] c = new int[26];
        for(int i = 0; i < s.length(); i++){
            c[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < order.length(); i++){
            char ch = order.charAt(i);
            for(int j = 0; j < c[ch - 'a']; j++){
                sb.append(ch);
            }
            c[ch - 'a'] = 0;
        }
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < c[i]; j++){
                sb.append((char)(97 + i));
            }
        }
        return sb.toString();
    }
}
