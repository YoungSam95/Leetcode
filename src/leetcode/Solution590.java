package leetcode;

import common.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 */
public class Solution590 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            helper(ch, res);
        }
        res.add(root.val);
    }
}
