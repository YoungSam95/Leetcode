package leetcode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 919. 完全二叉树插入器
 */
public class Solution919 {
    class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> q = new LinkedList<>();

        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> temp = new LinkedList<>();
            temp.offer(root);
            while(!temp.isEmpty()){
                TreeNode node = temp.poll();
                if(node.left != null) temp.offer(node.left);
                if(node.right != null) temp.offer(node.right);
                if(node.left == null || node.right == null) q.offer(node);
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            TreeNode father = q.peek();
            if(father.left == null){
                father.left = node;
            }else if(father.right == null){
                father.right = node;
                q.poll();
            }
            q.offer(node);
            return father.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
