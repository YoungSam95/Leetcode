package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 417. 太平洋大西洋水流问题
 */
public class Solution417 {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};//上下左右四个方向
    int[][] heights;
    int m, n;

    public  List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];//能流向太平洋
        boolean[][] atlantic = new boolean[m][n];//能流向大西洋
        for (int i = 0; i < m; i++) {//左边界
            dfs(i, 0, pacific);
        }
        for (int j = 1; j < n; j++) {//上边界
            dfs(0, j, pacific);
        }
        for (int i = 0; i < m; i++) {//右边界
            dfs(i, n - 1, atlantic);
        }
        for (int j = 0; j < n - 1; j++) {//下边界
            dfs(m - 1, j, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }
        return result;
    }

    public  void dfs(int row, int col, boolean[][] ocean) {
        if (ocean[row][col]) {
            return;
        }
        ocean[row][col] = true;
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && heights[newRow][newCol] >= heights[row][col]) {
                dfs(newRow, newCol, ocean);
            }
        }
    }

    public static void main(String[] args){
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        Solution417 solution417 = new Solution417();
        List<List<Integer>> result = solution417.pacificAtlantic(heights);
        System.out.println(result);
    }
}
