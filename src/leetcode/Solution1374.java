package leetcode;

/**
 * 1374. 生成每种字符都是奇数个的字符串
 */
public class Solution1374 {
    public String generateTheString(int n) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n - 1; i++){
            sb.append('a');
        }
        if(n % 2 == 0){
            sb.append("ab");
        }else{
            sb.append("a");
        }
        return sb.toString();
    }
}
