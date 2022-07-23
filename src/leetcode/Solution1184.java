package leetcode;

/**
 * 1184. 公交站间的距离
 */
public class Solution1184 {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int ans = 0, total = 0;
        for(int dis : distance){
            total += dis;
        }
        if(start > destination){
            int temp = start;
            start = destination;
            destination = temp;
        }
        for(int i = start; i < destination; i++){
            ans += distance[i];
        }
        return Math.min(ans,total - ans);
    }
}
