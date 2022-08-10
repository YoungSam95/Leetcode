package leetcode;

/**
 * 1417. 重新格式化字符串
 */
public class Solution1417 {
    public String reformat(String s) {
        char[] res = new char[s.length()];
        int sumDigit = 0, sumAlpha = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                sumDigit++;
            }else{
                sumAlpha++;
            }
        }
        if(Math.abs(sumDigit - sumAlpha) > 1) return "";
        /**多放偶少放奇**/
        int i = 0, j = 0;
        if(sumDigit >= sumAlpha){
            j++;
        }else{
            i++;
        }
        for(int idx = 0; idx < s.length(); idx++){
            if(Character.isDigit(s.charAt(idx))){
                res[i] = s.charAt(idx);
                i += 2;
            }else{
                res[j] = s.charAt(idx);
                j += 2;
            }
        }
        return new String(res);
    }
}
