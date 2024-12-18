package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 3285. 找到稳定山的下标
 */
public class Solution3285 {
    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold) {
                result.add(i);
            }
        }
        return result;
    }
}
