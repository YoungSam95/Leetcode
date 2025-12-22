package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2054. 两个最好的不重叠活动
 */
public class Solution2054 {
    public int maxTwoEvents(int[][] events) {
        List<Event> evs = new ArrayList<>();
        for (int[] event : events) {
            evs.add(new Event(event[0], 0, event[2]));
            evs.add(new Event(event[1], 1, event[2]));
        }
        Collections.sort(evs);
        int ans = 0, bestFirst = 0;
        for (Event event : evs) {
            if (event.op == 0) {
                ans = Math.max(ans, event.val + bestFirst);
            } else {
                bestFirst = Math.max(bestFirst, event.val);
            }
        }
        return ans;
    }

    class Event implements Comparable<Event> {
        int ts;
        int op;
        int val;

        Event(int ts, int op, int val) {
            this.ts = ts;
            this.op = op;
            this.val = val;
        }

        @Override
        public int compareTo(Event other) {
            if (this.ts != other.ts) {
                return Integer.compare(this.ts, other.ts);
            }
            return Integer.compare(this.op, other.op);
        }
    }
}
