package leetcode;

import common.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 652. 寻找重复的子树
 * 第二次
 */

public class Solution652 {

    //记录所有子树以及出现的次数
    private HashMap<String,Integer> memo = new HashMap<>();
    //记录重复的子树的根节点
    private LinkedList<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    public String traverse(TreeNode root){
        if(root == null) return "#";//#代表null

        String left = traverse(root.left);
        String right = traverse(root.right);
        String subTree = left + "," + right + "," + root.val;

        int freq = memo.getOrDefault(subTree,0);
        if(freq == 1){
            res.add(root);
        }
        memo.put(subTree,freq+1);
        return subTree;
    }
}
