package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 */
public class Solution1305 {
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        travel(root1,res);
        travel(root2,res);
        Collections.sort(res);
        return res;
    }

    public static void travel(TreeNode root, List<Integer> res) {
        if(root == null) return;
        res.add(root.val);
        travel(root.left,res);
        travel(root.right,res);
    }
}
