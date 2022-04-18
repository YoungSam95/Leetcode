package leetcode;

/**
 * 821. 字符的最短距离
 */
public class Solution821 {
    public int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            int pre = i;
            int after = i;
            while(pre >=0 || after < s.length()){
                if(s.charAt(pre) == c){
                    res[i] = Math.abs(i - pre);
                    break;
                }
                if(s.charAt(after) == c){
                    res[i] = Math.abs(i - after);
                    break;
                }
                if(pre > 0) pre--;
                if(after < s.length() - 1) after++;
            }
        }
        return res;
    }
}
