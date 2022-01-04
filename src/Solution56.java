import java.util.Arrays;
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
        // 按区间的 start 升序排列
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // res 中最后一个元素的引用
            int[] last = res.getLast();
            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                // 处理下一个待合并区间
                res.add(curr);
            }
        }
        return res.toArray(new int[0][0]);

    }

    public static void main(String[] args){

        int[][] intercals = {{1,3},{2,6},{8,10},{15,18}};
        intercals = merge(intercals);
        for(int i = 0; i < intercals.length; i++){
            for(int j = 0; j < intercals[i].length; j++){
                System.out.printf("%5d",intercals[i][j]);
            }
            System.out.println();
        }

    }

}
