package leetcode;

import java.util.Arrays;

/**
 * 646. 最长数对链
 */
public class Solution646 {
    public int findLongestChain(int[][] pairs) {
        int res = 0, cur = Integer.MIN_VALUE;
        Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
        for(int[] pair : pairs){
            if(cur < pair[0]){
                res++;
                cur = pair[1];
            }
        }
        return res;
    }
}
