package leetcode;

import common.TreeNode;

import java.util.*;

/**
 * 2385. 感染二叉树需要的总时间
 */
public class Solution2385 {
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        dfs(graph, root);
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{start, 0});
        Set<Integer> visited = new HashSet<Integer>();
        visited.add(start);
        int time = 0;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int nodeVal = arr[0];
            time = arr[1];
            for (int childVal : graph.get(nodeVal)) {
                if (visited.add(childVal)) {
                    queue.offer(new int[]{childVal, time + 1});
                }
            }
        }
        return time;
    }

    public void dfs(Map<Integer, List<Integer>> graph, TreeNode node) {
        graph.putIfAbsent(node.val, new ArrayList<Integer>());
        for (TreeNode child : Arrays.asList(node.left, node.right)) {
            if (child != null) {
                graph.get(node.val).add(child.val);
                graph.putIfAbsent(child.val, new ArrayList<Integer>());
                graph.get(child.val).add(node.val);
                dfs(graph, child);
            }
        }
    }
}
