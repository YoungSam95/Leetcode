package leetcode;

import common.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261.在受污染的二叉树中查找元素
 */
public class Solution1261 {
    class FindElements {
        private Set<Integer> valSet;

        public FindElements(TreeNode root) {
            this.valSet = new HashSet<>();
            dfs(root, 0);
        }

        public boolean find(int target) {
            return valSet.contains(target);
        }

        private void dfs(TreeNode node, int val) {
            if (node == null) {
                return;
            }
            node.val = val;
            valSet.add(val);
            dfs(node.left, val * 2 + 1);
            dfs(node.right, val * 2 + 2);
        }
    }
}
