package leetcode;

/**
 * 436. 寻找右区间
 */
public class Solution436 {
    public static int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            int min = Integer.MAX_VALUE,index = Integer.MAX_VALUE;
            for(int j = 0; j < intervals.length; j++){
                if(intervals[j][0] >= intervals[i][1]){
                    if(intervals[j][0] - intervals[i][1] < min){
                        min = intervals[j][0] - intervals[i][1];
                        index = j;
                    }
                }
            }
            res[i] = index == Integer.MAX_VALUE ? -1 : index;
        }
        return res;
    }
    public static void main(String[] args){
        int[][] intervals = {{3,4},{2,3},{1,2}};
        System.out.println(findRightInterval(intervals));
    }
}
