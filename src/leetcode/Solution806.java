package leetcode;

/**
 * 806. 写字符串需要的行数
 */
public class Solution806 {
    public static int[] numberOfLines(int[] widths, String s) {
        int count = 0;
        int row = 1;
        int last = 0;
        for(int i = 0; i < s.length(); i++){
            count += widths[s.charAt(i) - 'a'];
            if(count > 100){
                count = widths[s.charAt(i) - 'a'];
                row++;
            }
            last = count;
        }
        return new int[]{row,last};
    }
    public static void main(String[] args){
        int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(numberOfLines(widths,s)[0]+ " "+ numberOfLines(widths,s)[1]);
    }
}
