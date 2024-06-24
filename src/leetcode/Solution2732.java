package leetcode;

import java.util.*;

/**
 * 2732. 找到矩阵中的好子集
 */
public class Solution2732 {
    public List<Integer> goodSubsetofBinaryMatrix(int[][] grid) {
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        int m = grid.length;
        int n = grid[0].length;

        for (int j = 0; j < m; j++) {
            int st = 0;
            for (int i = 0; i < n; i++) {
                st |= (grid[j][i] << i);
            }
            mp.put(st, j);
        }

        if (mp.containsKey(0)) {
            ans.add(mp.get(0));
            return ans;
        }

        for (Map.Entry<Integer, Integer> entry1 : mp.entrySet()) {
            int x = entry1.getKey(), i = entry1.getValue();
            for (Map.Entry<Integer, Integer> entry2 : mp.entrySet()) {
                int y = entry2.getKey(), j = entry2.getValue();
                if ((x & y) == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(Math.min(i, j));
                    list.add(Math.max(i, j));
                    return list;
                }
            }
        }

        return ans;
    }
}
