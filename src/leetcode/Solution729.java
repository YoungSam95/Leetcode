package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 729. 我的日程安排表 I
 * 第二次
 */
public class Solution729 {
    class MyCalendar {
        private List<int[]> booked;

        public MyCalendar() {
            booked = new ArrayList<int[]>();
        }

        public boolean book(int start, int end) {
            for (int[] arr : booked) {
                int l = arr[0], r = arr[1];
                if (l < end && start < r) {
                    return false;
                }
            }
            booked.add(new int[]{start, end});
            return true;
        }
    }
}
