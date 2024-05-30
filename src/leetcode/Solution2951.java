package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2951. 找出峰值
 */
public class Solution2951 {
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                res.add(i);
            }
        }
        return res;
    }
}
