package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2080. 区间内查询数字的频率
 */
public class Solution2080 {
    class RangeFreqQuery {
        // 数值为键，出现下标数组为值的哈希表
        private Map<Integer, List<Integer>> occurrence;

        public RangeFreqQuery(int[] arr) {
            occurrence = new HashMap<>();
            // 顺序遍历数组初始化哈希表
            for (int i = 0; i < arr.length; ++i) {
                occurrence.putIfAbsent(arr[i], new ArrayList<>());
                occurrence.get(arr[i]).add(i);
            }
        }

        public int query(int left, int right, int value) {
            // 查找对应的出现下标数组，不存在则为空
            List<Integer> pos = occurrence.getOrDefault(value, new ArrayList<>());
            // 两次二分查找计算子数组内出现次数
            int l = lowerBound(pos, left);
            int r = upperBound(pos, right);
            return r - l;
        }

        private int lowerBound(List<Integer> pos, int target) {
            int low = 0, high = pos.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        private int upperBound(List<Integer> pos, int target) {
            int low = 0, high = pos.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }
    }
}
