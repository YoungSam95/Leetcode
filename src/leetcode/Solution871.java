package leetcode;

import java.util.PriorityQueue;

/**
 * 871. 最低加油次数
 */
public class Solution871 {
    /**动态规划
     * dp[i]表示加油i次能到达的最大距离
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long[] dp = new long[n + 1];
        dp[0] = startFuel;
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(dp[j] >= stations[i][0]){
                    dp[j + 1] = Math.max(dp[j + 1],dp[j] + stations[i][1]);
                }
            }
        }
        for(int i = 0; i < dp.length; i++){
            if(dp[i] >= target){
                return i;
            }
        }
        return -1;
    }

    /**贪心
     * 在保证能到达下一个加油站或者目的地的情况下，每次都在油最多的加油站加油，这样加油次数最少
     */
    public int minRefuelStops1(int target, int startFuel, int[][] stations){
        //优先队列，经过的油最多的加油站位于队首
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b - a);
        int curFuel = startFuel, ans = 0, index = 0;
        while(curFuel < target){
            //当前油量可以开到下一个加油站，暂时不加油
            if(index < stations.length && curFuel >= stations[index][0]){
                q.add(stations[index][1]);
                index++;
            }else{//无法到达，选择加油
                if(!q.isEmpty()){//优先队列有元素，选择最多油的加油站加油
                    curFuel += q.poll();
                    ans++;
                }else{//优先队列没有元素，说明加了所有的油也无法到达目的地
                    return -1;
                }
            }
        }
        return ans;
    }
}
