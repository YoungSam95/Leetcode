package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ43 {

    static int[][] maze;
    static boolean[][] visited;
    static int dx,dy;
    static List<int[]> path;
    static List<int[]> res;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            maze = new int[n][m];
            visited = new boolean[n][m];
            dx = n-1;
            dy = m -1;
            for(int i = 0;i < n;i++){
                for(int j = 0; j < m;j++){
                    maze[i][j] = sc.nextInt();
                }
            }
            path = new ArrayList<>();
            res = new ArrayList<>();
            findWay(maze,0,0);
            StringBuilder sb = new StringBuilder();
            for (int[] p : res) {
                sb.append('(').append(p[0]).append(',').append(p[1]).append(")\n");
            }
            System.out.print(sb.toString());
        }
    }

    public static void findWay(int[][] maze, int x, int y){
        if(x<0 || x>maze.length-1 ||
           y<0 || y>maze[0].length-1 ||
           visited[x][y] || maze[x][y]==1){
            return;
        }
        if(x == dx && y == dy){
            path.add(new int[]{x,y});
            if(res.size()==0 || path.size()<res.size()){//遇到更短的路径
                res.clear();//清空之前的路径
                for(int[] p:path){
                    res.add(p);
                }
            }
            return;
        }
        visited[x][y] = true;
        path.add(new int[]{x,y});
        findWay(maze,x,y-1);//向左
        findWay(maze,x,y+1);//向右
        findWay(maze,x-1,y);//向上
        findWay(maze,x+1,y);//向下
        visited[x][y] = false;
        path.remove(path.size()-1);
    }
}
