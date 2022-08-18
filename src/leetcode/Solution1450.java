package leetcode;

/**
 * 1450. 在既定时间做作业的学生人数
 */
public class Solution1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for(int i = 0; i < startTime.length; i++){
            if(startTime[i] <= queryTime && queryTime <= endTime[i]){
                res++;
            }
        }
        return res;
    }
}
