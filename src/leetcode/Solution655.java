package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. 输出二叉树
 */
public class Solution655 {
    public List<List<String>> printTree(TreeNode root) {
        int m = height(root);
        int n = (1 << m) - 1;
        List<List<String>> res = new ArrayList<>();
        for(int i = 0; i < m; i++){
            List<String> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add("");
            }
            res.add(temp);
        }
        out(root,0,0, n - 1,res);
        return res;
    }

    public void out(TreeNode root, int level, int l, int r, List<List<String>> res) {
        if(root == null) return;
        int mid = (l + r) >> 1;
        res.get(level).set(mid,String.valueOf(root.val));
        out(root.left,level + 1, l, mid - 1, res);
        out(root.right, level + 1, mid + 1, r, res);
    }

    public int height(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(height(root.left),height(root.right));
    }
}
