package common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
    public TreeNode deserialize(String[] nodes){
        if(nodes.length == 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i = 1; i < nodes.length;){
            //队列中存的都是父节点
            TreeNode parent = q.poll();
            //左节点
            String left = nodes[i++];
            if(!left.equals("null")){
                parent.left = new TreeNode(Integer.parseInt(left));
            }else{
                parent.left = null;
            }
            //右节点
            String right = nodes[i++];
            if(!right.equals("null")){
                parent.right = new TreeNode(Integer.parseInt(right));
            }else{
                parent.right = null;
            }
        }
        return root;
    }
}
