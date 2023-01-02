package leetcode;

/**
 * 2042. 检查句子中的数字是否递增
 */
public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        int num = -1;
        String[] tokens = s.split(" ");
        for(String token : tokens){
            if(Character.isDigit(token.charAt(0))){
                int temp = Integer.parseInt(token);
                if(temp <= num){
                    return false;
                }
                num = temp;
            }
        }
        return true;
    }

}
