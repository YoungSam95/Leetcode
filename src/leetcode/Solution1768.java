package leetcode;

/**
 * 1768. 交替合并字符串
 */
public class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        /*int index = 0, n1 = word1.length(), n2 = word2.length();
        while(index < n1 && index < n2){
            res.append(word1.charAt(index)).append(word2.charAt(index));
            index++;
        }
        if(index < n1) res.append(word1.substring(index));
        if(index < n2) res.append(word2.substring(index));*/
        int i = 0, j = 0, n1 = word1.length(), n2 = word2.length();
        while(i < n1 || j < n2){
            if(i < n1){
                res.append(word1.charAt(i++));
            }
            if(j < n2){
                res.append(word2.charAt(j++));
            }
        }
        return res.toString();
    }
}
