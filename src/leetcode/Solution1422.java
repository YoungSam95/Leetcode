package leetcode;

/**
 * 1422. 分割字符串的最大得分
 */
public class Solution1422 {
    public int maxScore(String s) {
        int score = 0;
        int n = s.length();
        if(s.charAt(0) == '0') score++;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '1') score++;
        }
        int res = score;
        for(int i = 1; i < n - 1; i++){
            if(s.charAt(i) == '0'){
                score++;
            }else{
                score--;
            }
            res = Math.max(res,score);
        }
        return res;
    }
}
