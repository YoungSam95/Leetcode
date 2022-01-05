import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * 56. 合并区间
 *     以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *     示例：
 *     输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 *     输出：[[1,6],[8,10],[15,18]]
 *     解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *解题思路：
 *
 */
public class Solution56 {

    public static int[][] merge(int[][] intervals){

        LinkedList<int[]> res = new LinkedList<>();
        //按区间start升序排列
        Arrays.sort(intervals, (a,b) -> {
            return a[0] - b[0];
        });
        /*Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });*/

        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++ ){
            int[] last = res.getLast();//得到res中最后一个int[]的引用
            if(intervals[i][0] <= last[1]){//如果当前intervals[i]的start<=last[1]，找出最大的end替换last[1]
                last[1] = Math.max(last[1],intervals[i][1]);
            }else {
                res.add(intervals[i]);//如果不是就将当前的intervals加入到结果中
            }
        }
        return res.toArray(new int[0][0]);

    }

    public static void main(String[] args){

        int[][] intercals = {{2,6},{1,3},{8,10},{15,18}};
        intercals = merge(intercals);
        for(int i = 0; i < intercals.length; i++){
            for(int j = 0; j < intercals[i].length; j++){
                System.out.printf("%5d",intercals[i][j]);
            }
            System.out.println();
        }

    }

}
