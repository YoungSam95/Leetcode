package leetcode;

import java.util.Arrays;

/**
 * 2332. 坐上公交的最晚时间
 */
public class Solution2332 {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int pos = 0;
        int space = 0;

        for (int arrive : buses) {
            space = capacity;
            while (space > 0 && pos < passengers.length && passengers[pos] <= arrive) {
                space--;
                pos++;
            }
        }

        pos--;
        int lastCatchTime = space > 0 ? buses[buses.length - 1] : passengers[pos];
        while (pos >= 0 && passengers[pos] == lastCatchTime) {
            pos--;
            lastCatchTime--;
        }

        return lastCatchTime;
    }
}
