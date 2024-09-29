package leetcode;

import java.util.PriorityQueue;

/**
 * 1845. 座位预约管理系统
 */
public class Solution1845 {
    class SeatManager {
        private PriorityQueue<Integer> available;
        public SeatManager(int n) {
            available = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                available.offer(i);
            }
        }

        public int reserve() {
            return available.poll();
        }

        public void unreserve(int seatNumber) {
            available.offer(seatNumber);
        }
    }
}
