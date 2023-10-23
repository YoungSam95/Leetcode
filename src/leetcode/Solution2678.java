package leetcode;

/**
 * 2678. 老人的数目
 */
public class Solution2678 {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String info : details) {
            if (Integer.parseInt(info.substring(11, 13)) > 60) {
                count++;
            }
        }
        return count;
    }
}
