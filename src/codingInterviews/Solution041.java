package codingInterviews;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer II 041. 滑动窗口的平均值
 */
public class Solution041 {
    class MovingAverage {

        private int size;
        private Queue<Integer> queue;
        double sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            queue = new ArrayDeque<>();
            sum = 0;
        }

        public double next(int val) {
            if(queue.size() == size){
                sum -= queue.poll();
            }
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        }
    }
}
