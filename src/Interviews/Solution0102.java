package Interviews;

import java.util.Arrays;

/**
 * 面试题 01.02. 判定是否互为字符重排
 */
public class Solution0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        Arrays.sort(cs1);
        Arrays.sort(cs2);
        for(int i = 0; i < cs1.length; i++){
            if(cs1[i] != cs2[i]) return false;
        }
        return true;
    }
}
