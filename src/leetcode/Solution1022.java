package leetcode;

import common.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 */
public class Solution1022 {
    int res = 0;
    int path = 0;
    public int sumRootToLeaf(TreeNode root) {
        sum(root);
        return res;
    }

    public void sum(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res += path * 2 + root.val;
            return;
        }
        path = path * 2 + root.val;
        sum(root.left);
        sum(root.right);
        path /= 2;
    }
    public static void main(String[] args){
        Solution1022 s = new Solution1022();
        TreeNode root = new TreeNode().deserialize("1,0,1,0,1,0,1");
        System.out.println(s.sumRootToLeaf(root));
    }
}
