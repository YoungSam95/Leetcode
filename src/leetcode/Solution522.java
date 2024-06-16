package leetcode;

import java.util.Arrays;

/**
 * 522. 最长特殊序列 II
 * 第二次
 */
public class Solution522 {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a,b) -> b.length() - a.length());
        int n = strs.length;
        for(int i = 0; i < n; i++){
            if(!isSub(strs,i)) return strs[i].length();
        }
        return -1;
    }

    public boolean isSub(String[] strs, int index) {
        for(int i = 0; i < strs.length; i++){
            if(i == index) continue;
            if(strs[i].length() < strs[index].length()) break;
            if(check(strs[index],strs[i])) return true;
        }
        return false;
    }

    public boolean check(String s1, String s2) {
        int p1 = 0, p2 = 0;
        while(p1 < s1.length() && p2 < s2.length()){
            while(p2 < s2.length() && s2.charAt(p2) != s1.charAt(p1)){
                p2++;
            }
            if(p2 < s2.length()){
                p1++;
            }
            p2++;
        }
        return p1 == s1.length();
    }

}
