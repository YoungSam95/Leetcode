package leetcode;

import java.util.Arrays;

/**
 * 2037. 使每位学生都有座位的最少移动次数
 */
public class Solution2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int res = 0;
        for(int i = 0; i < students.length; i++){
            res += Math.abs(students[i] - seats[i]);
        }
        return res;
    }
}
