package leetcode;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 */
public class Solution513 {
    //DFS
    /*TreeNode res = null;
    int maxDepth = 0;
    int depth = 0;
    public int findBottomLeftValue(TreeNode root) {
        search(root);
        return res.val;
    }
    public void search(TreeNode root) {
        if(root == null){
            return;
        }
        depth++;
        if(depth > maxDepth){
            maxDepth = depth;
            res = root;
        }
        search(root.left);
        search(root.right);
        depth--;
    }*/
    //BFS
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            res = q.peek().val;
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
        }
        return res;
    }
}
