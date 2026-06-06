package leetcode;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2196. 根据描述创建二叉树
 */
public class Solution2196 {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Boolean> isRoot = new HashMap<>();  // 数值对应的节点是否为根节点的哈希表
        Map<Integer, TreeNode> nodes = new HashMap<>();  // 数值与对应节点的哈希表

        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];
            boolean left = d[2] == 1;

            if (!isRoot.containsKey(p)) {
                isRoot.put(p, true);
            }
            isRoot.put(c, false);

            // 创建或更新节点
            if (!nodes.containsKey(p)) {
                nodes.put(p, new TreeNode(p));
            }
            if (!nodes.containsKey(c)) {
                nodes.put(c, new TreeNode(c));
            }

            if (left) {
                nodes.get(p).left = nodes.get(c);
            } else {
                nodes.get(p).right = nodes.get(c);
            }
        }

        // 寻找根节点
        int root = -1;
        for (Map.Entry<Integer, Boolean> entry : isRoot.entrySet()) {
            if (entry.getValue()) {
                root = entry.getKey();
                break;
            }
        }

        return nodes.get(root);
    }
}
