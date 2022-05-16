package common;

import java.util.ArrayDeque;
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
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            if (cur == null) {
                sb.append("null").append(",");
                continue;
            }
            sb.append(cur.val).append(",");

            q.offer(cur.left);
            q.offer(cur.right);
        }

        return sb.toString();
    }
    public TreeNode deserialize(String data){
        if (data.isEmpty()) return null;
        String[] nodes = data.split(",");
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
                q.offer(parent.left);
            }else{
                parent.left = null;
            }
            //右节点
            String right = nodes[i++];
            if(!right.equals("null")){
                parent.right = new TreeNode(Integer.parseInt(right));
                q.offer(parent.right);
            }else{
                parent.right = null;
            }
        }
        return root;
    }
}
