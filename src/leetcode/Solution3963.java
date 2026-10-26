package leetcode;

/**
 * 3963. 构造恰好一条路径的网格
 */
public class Solution3963 {
    public String[] createGrid(int m, int n) {
        String[] grid = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < n; j++) {
                sb.append(i == 0 || j == n - 1 ? '.' : '#');
            }
            grid[i] = sb.toString();
        }
        return grid;
    }
}
