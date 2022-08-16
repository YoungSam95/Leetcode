package leetcode;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1302. 层数最深叶子节点的和
 */
public class Solution1302 {
    public int deepestLeavesSum(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            res = 0 ;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                res += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}
