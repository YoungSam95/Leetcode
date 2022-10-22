package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 1235. 规划兼职工作
 */
public class Solution1235 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(new int[]{startTime[i], endTime[i], profit[i]});
        Collections.sort(list, (a, b)->a[1] - b[1]);
        int[] f = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            int[] info = list.get(i - 1);
            int a = info[0], b = info[1], c = info[2];
            f[i] = Math.max(f[i - 1], c);
            int l = 0, r = i - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid)[1] <= a) l = mid;
                else r = mid - 1;
            }
            if (list.get(r)[1] <= a) f[i] = Math.max(f[i], f[r + 1] + c);
        }
        return f[n];
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
        int[] startTime = {1,1,1};
        int[] endTime = {2,3,4};
        int[] profit = {5,6,4};
        System.out.println(new Solution1235().jobScheduling1(startTime,endTime,profit));
    }
}
