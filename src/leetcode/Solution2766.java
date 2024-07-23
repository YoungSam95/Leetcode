package leetcode;

import java.util.*;

/**
 * 2766. 重新放置石块
 */
public class Solution2766 {
    public List<Integer> relocateMarbles(int[] nums, int[] moveFrom, int[] moveTo) {
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Boolean> mp = new HashMap<Integer, Boolean>();

        for (int i = 0; i < nums.length; i++) {
            mp.put(nums[i], true);
        }

        for (int i = 0; i < moveFrom.length; i++) {
            mp.remove(moveFrom[i]);
            mp.put(moveTo[i], true);
        }

        for (Map.Entry<Integer, Boolean> entry : mp.entrySet()) {
            ans.add(entry.getKey());
        }
        Collections.sort(ans);
        return ans;
    }
}
