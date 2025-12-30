package leetcode;

import java.util.Arrays;

/**
 * 1970. 你能穿过矩阵的最后一天
 */
public class Solution1907 {
    class UnionFind {
        public int[] parent;
        public int[] size;
        public int n;
        // 当前连通分量数目
        public int setCount;

        public UnionFind(int _n) {
            n = _n;
            setCount = _n;
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findset(int x) {
            return parent[x] == x ? x : (parent[x] = findset(parent[x]));
        }

        public boolean unite(int x, int y) {
            x = findset(x);
            y = findset(y);
            if (x == y) {
                return false;
            }
            if (size[x] < size[y]) {
                int temp = x;
                x = y;
                y = temp;
            }
            parent[y] = x;
            size[x] += size[y];
            --setCount;
            return true;
        }

        public boolean connected(int x, int y) {
            return findset(x) == findset(y);
        }
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        // 编号为 n 的节点是超级节点 s
        // 编号为 n+1 的节点是超级节点 t
        int n = row * col;
        UnionFind uf = new UnionFind(n + 2);
        int[][] valid = new int[row][col];
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
            int x = cells[i][0] - 1, y = cells[i][1] - 1;
            valid[x][y] = 1;
            // 并查集是一维的，(x, y) 坐标是二维的，需要进行转换
            int id = x * col + y;
            if (x - 1 >= 0 && valid[x - 1][y] == 1) {
                uf.unite(id, id - col);
            }
            if (x + 1 < row && valid[x + 1][y] == 1) {
                uf.unite(id, id + col);
            }
            if (y - 1 >= 0 && valid[x][y - 1] == 1) {
                uf.unite(id, id - 1);
            }
            if (y + 1 < col && valid[x][y + 1] == 1) {
                uf.unite(id, id + 1);
            }
            if (x == 0) {
                uf.unite(id, n);
            }
            if (x == row - 1) {
                uf.unite(id, n + 1);
            }
            if (uf.connected(n, n + 1)) {
                ans = i;
                break;
            }
        }
        return ans;
    }
}
