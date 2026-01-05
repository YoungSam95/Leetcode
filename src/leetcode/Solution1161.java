package leetcode;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * 第二次
 */
public class Solution1161 {
    public int maxLevelSum(TreeNode root) {
        int currLevel = 1, minLevel = 1, maxSum = root.val;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            int sum = 0, size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                minLevel = currLevel;
            }
            currLevel++;
        }
        return minLevel;
    }
}
