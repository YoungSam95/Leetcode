package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 894. 所有可能的真二叉树
 */
public class Solution894 {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<TreeNode>();
        }

        List<TreeNode>[] dp = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<TreeNode>();
        }
        dp[1].add(new TreeNode(0));
        for (int i = 3; i <= n; i += 2) {
            for (int j = 1; j < i; j += 2) {
                for (TreeNode leftSubtree : dp[j]) {
                    for (TreeNode rightSubtrees : dp[i - 1 - j]) {
                        TreeNode root = new TreeNode(0, leftSubtree, rightSubtrees);
                        dp[i].add(root);
                    }
                }
            }
        }
        return dp[n];
    }
}
