package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 934. 最短的桥
 */
public class Solution934 {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    Queue<int[]> queue = new ArrayDeque<>();
                    searchIsland(i,j,grid,queue);
                    int step = 0;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        for(int k = 0; k < size; k++){
                            int[] cell = queue.poll();
                            int x = cell[0], y = cell[1];
                            for(int[] dir : dirs){
                                int dx = x + dir[0];
                                int dy = y + dir[1];
                                if(dx >= 0 && dy >= 0 && dx < n && dy <n){
                                    if(grid[dx][dy] == 0){
                                        queue.offer(new int[] {dx,dy});
                                        grid[dx][dy] = -1;
                                    }else if(grid[dx][dy] == 1){
                                        return step;
                                    }
                                }
                            }
                        }
                        step++;
                    }
                }
            }
        }
        return 0;
    }

    public void searchIsland(int x, int y, int[][] grid, Queue<int[]> queue) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1) {
            return;
        }
        queue.offer(new int[]{x, y});
        grid[x][y] = -1;
        searchIsland(x - 1, y, grid, queue);
        searchIsland(x + 1, y, grid, queue);
        searchIsland(x, y - 1, grid, queue);
        searchIsland(x, y + 1, grid, queue);
    }
    public static void main(String[] args){
        int[][] grid = {{0,1},{1,0}};
        System.out.println(new Solution934().shortestBridge(grid));
    }
}
