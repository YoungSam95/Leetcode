package leetcode;

/**
 * 1061. 按字典序排列最小的等效字符串
 */
public class Solution1061 {
    class UnionFind {
        int[] parent;

        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void unite(int x, int y) {
            x = find(x);
            y = find(y);
            if (x == y) return;
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            // 总是让字典序更小的作为集合代表字符
            parent[y] = x;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UnionFind uf = new UnionFind(26);
        for (int i = 0; i < s1.length(); i++) {
            uf.unite(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) ('a' + uf.find(c - 'a')));
        }
        return sb.toString();
    }
}
