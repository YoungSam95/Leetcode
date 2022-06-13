package leetcode;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 */

public class Solution1051 {

    /*public int heightChecker(int[] heights) {
        int res = 0, n = heights.length;
        int[] expected = new int[n];
        *//**for(int i = 0; i < n; i++){
            expected[i] = heights[i];
        }**//*
        System.arraycopy(heights,0,expected,0,n);
        Arrays.sort(expected);
        for(int i = 0; i < n; i++){
            if(expected[i] != heights[i]) res++;
        }
        return res;
    }*/
    public int heightChecker(int[] heights) {
        int res = 0;
        int[] arr = new int[101];
        for(int height : heights){
            arr[height]++;
        }
        for(int i = 1, j = 0; i < arr.length;i++){
            while(arr[i]-- > 0){
                if(heights[j++] != i) res++;
            }
        }
        return res;
    }
}
