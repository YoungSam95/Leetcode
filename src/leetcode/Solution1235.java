package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1235. 规划兼职工作
 * 第二次
 */
public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    public int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for(int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs,(a,b) -> a[1] - b[1]);
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int pre = 0;
            for(int j = i - 2; j >= 0; j--){
                if(jobs[j][1] <= jobs[i - 1][0]){
                    pre = j + 1;
                    break;
                }
            }
            dp[i] = Math.max(dp[i - 1],dp[pre] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    public static void main(String[] args){
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};
        System.out.println(new Solution1235().jobScheduling(startTime,endTime,profit));
    }
}
