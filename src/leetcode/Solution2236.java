package leetcode;

import common.TreeNode;

/**
 * 2236. 判断根结点是否等于子结点之和
 */
public class Solution2236 {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
