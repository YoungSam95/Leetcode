package leetcode;

import java.util.*;

/**
 * 2003. 每棵子树内缺失的最小基因值
 */
public class Solution2003 {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        List<Integer>[] children = new List[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<Integer>();
        }
        for (int i = 1; i < n; i++) {
            children[parents[i]].add(i);
        }

        Set<Integer> geneSet = new HashSet<Integer>();
        boolean[] visited = new boolean[n];

        int[] res = new int[n];
        Arrays.fill(res, 1);
        int iNode = 1, node = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                node = i;
                break;
            }
        }
        while (node != -1) {
            dfs(node, nums, children, geneSet, visited);
            while (geneSet.contains(iNode)) {
                iNode++;
            }
            res[node] = iNode;
            node = parents[node];
        }
        return res;
    }

    public void dfs(int node, int[] nums, List<Integer>[] children, Set<Integer> geneSet, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        geneSet.add(nums[node]);
        for (int child : children[node]) {
            dfs(child, nums, children, geneSet, visited);
        }
    }
}
