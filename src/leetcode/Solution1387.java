package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1387. 将整数按权重排序
 */
public class Solution1387 {
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = lo; i <= hi; ++i) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer u, Integer v) {
                if (getF(u) != getF(v)) {
                    return getF(u) - getF(v);
                } else {
                    return u - v;
                }
            }
        });
        return list.get(k - 1);
    }

    public int getF(int x) {
        if (x == 1) {
            return 0;
        } else if ((x & 1) != 0) {
            return getF(x * 3 + 1) + 1;
        } else {
            return getF(x / 2) + 1;
        }
    }
}
