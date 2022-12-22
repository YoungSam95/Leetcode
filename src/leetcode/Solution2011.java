package leetcode;

/**
 * 2011. 执行操作后的变量值
 */
public class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int X = 0;
        for(String op : operations){
            if(op.equals("--X") || op.equals("X--")){
                X--;
            }else{
                X++;
            }
        }
        return X;
    }
}
