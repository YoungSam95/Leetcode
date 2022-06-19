package leetcode;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 508. 出现次数最多的子树元素和
 */
public class Solution508 {
    Map<Integer,Integer> map = new HashMap<>();
    int maxCount = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        sum(root);
        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == maxCount){
                list.add(key);
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

    public int sum(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = sum(root.left);
        int right = sum(root.right);
        int res = root.val + left + right;
        map.put(res,map.getOrDefault(res,0) + 1);
        maxCount = Math.max(maxCount,map.get(res));
        return res;
    }
}
