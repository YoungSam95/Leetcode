package leetcode;

/**
 * 1779. 找到最近的有相同 X 或 Y 坐标的点
 */
public class Solution1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int res = -1, distance = Integer.MAX_VALUE, dis = 0;
        for(int i = 0; i < points.length; i++){
            if(x == points[i][0] || y == points[i][1]){
                dis = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);
                if(dis < distance){
                    res = i;
                    distance = dis;
                }
            }
        }
        return res;
    }
}
