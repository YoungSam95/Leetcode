package leetcode;

import java.util.Arrays;

/**
 * 952. 按公因数计算最大组件大小
 */
public class Solution952 {
    private class UnionFind {
        private int[] parent;
        public UnionFind(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }
        // 使用了路径压缩
        public int find(int x) {
            while (parent[x] != x) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }
        // 没有实现按秩合并
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }
    public int largestComponentSize(int[] nums) {
        int maxVal = Arrays.stream(nums).max().getAsInt();

        // 0 位置不使用，因此需要 + 1
        UnionFind unionFind = new UnionFind(maxVal + 1);

        for (int num : nums) {
            double upBound = Math.sqrt(num);
            for (int i = 2; i <= upBound; i++) {
                if (num % i == 0) {
                    unionFind.union(num, i);
                    unionFind.union(num, num / i);
                }
            }
        }

        // 将候选数组映射成代表元，统计代表元出现的次数，找出最大者
        int[] cnt = new int[maxVal + 1];
        int res = 0;
        for (int num : nums) {
            int root = unionFind.find(num);
            cnt[root]++;
            res = Math.max(res, cnt[root]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] nums = {4,6,15,35};
        Solution952 s = new Solution952();
        System.out.println(s.largestComponentSize(nums));
    }
}
