import java.util.Arrays;

/**
 * 695. 岛屿的最大面积
 *      给定一个包含了一些 0 和 1 的非空二维数组grid 。
 *      一个岛屿是由一些相邻的(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
 *      你可以假设grid 的四个边缘都被 0（代表水）包围着。
 *      找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * 解题思路：
 *      深度优先；
 *      递归；
 *      沉到思想：将当前岛标记为零 避免重复查找。
 */
public class Solution695 {

    public static int maxAreaOfIsland(int[][] grid) {

        int res = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    res =  Math.max(res,dfs(i,j,grid));
                }
            }
        }
        return res;
    }
    private static int dfs(int i,int j,int[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0 ){
            return 0 ;
        }
        grid[i][j] = 0;
        int num =1;
        num += dfs(i-1,j,grid);
        num += dfs(i+1,j,grid);
        num += dfs(i,j-1,grid);
        num += dfs(i,j+1,grid);
        return num;
    }

    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }
}
