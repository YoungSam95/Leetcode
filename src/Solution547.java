/**
 * 547. 省份数量
 *      有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 *      省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 *      给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。
 *      返回矩阵中 省份 的数量。
 * 解题思路：深度优先搜索
 */
public class Solution547 {

    public static int findCircleNum(int[][] isConnected) {
        int citys = isConnected.length;//城市数量
        boolean[] visited = new boolean[citys];//城市是否被遍历过
        int provinces = 0;//省份个数
        for (int i = 0; i < citys; i++) {
            if (!visited[i]) {//碰到一个未遍历过的城市，先进行深度优先搜索，找到所有联通城市并标记遍历过，省份加1；
                dfs(isConnected, visited, citys, i);
                provinces++;
            }
        }
        return provinces;
    }

    public static void dfs(int[][] isConnected, boolean[] visited, int citys, int i) {
        for (int j = 0; j < citys; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {//如果当前城市和主体中的城市联通且还没遍历过，标记遍历，并以
                visited[j] = true;                      //当前城市为主体深度搜索
                dfs(isConnected, visited, citys, j);
            }
        }
    }


    public static void main(String[] args){

        int[][] m = {{1,1,0},{1,1,0},{0,0,1}};
        //int[][] n = {{1,1,0},{1,1,1},{0,1,1}};
        System.out.println(findCircleNum(m));
        //System.out.println(findCircleNum(n));
    }
}
