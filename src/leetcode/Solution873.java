package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 873. 最长的斐波那契子序列的长度
 */
public class Solution873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length, ans = 0;
        int[][] dp = new int[n][n];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(arr[i],i);
        }
        for(int i = 0; i < n; i++){
            for(int j = i - 1; j >= 0 && arr[j] * 2 > arr[i]; j--){
                int k = map.getOrDefault(arr[i] - arr[j],-1);
                if(k >= 0){
                    dp[j][i] = Math.max(dp[k][j] + 1,3);
                    ans = Math.max(ans,dp[j][i]);
                }
            }
        }
        return ans;
    }
}
