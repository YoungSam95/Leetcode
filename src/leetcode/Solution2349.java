package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 2349. 设计数字容器系统
 */
public class Solution2349 {
    class NumberContainers {

        private Map<Integer, Integer> nums;
        private Map<Integer, TreeSet<Integer>> us;

        public NumberContainers() {
            nums = new HashMap<>();
            us = new HashMap<>();
        }

        public void change(int index, int number) {
            int prev = nums.getOrDefault(index, 0);
            if (prev != 0) {
                TreeSet<Integer> set = us.get(prev);
                if (set != null) {
                    set.remove(index);
                }
            }
            us.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
            nums.put(index, number);
        }

        public int find(int number) {
            TreeSet<Integer> set = us.get(number);
            if (set == null || set.isEmpty()) {
                return -1;
            }
            return set.first();
        }
    }
}
