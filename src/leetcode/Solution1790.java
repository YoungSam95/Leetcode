package leetcode;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 */
public class Solution1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0, idx1 = -1, idx2 = -1;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count > 2) return false;
                if(idx1 == -1){
                    idx1 = i;
                }else{
                    idx2 = i;
                }
            }
        }
        if(count == 0) return true;
        if(count == 1) return false;
        if(s1.charAt(idx1) != s2.charAt(idx2) || s1.charAt(idx2) != s2.charAt(idx1)) return false;
        return true;
    }
}
