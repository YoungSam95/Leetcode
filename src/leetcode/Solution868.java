package leetcode;

/**
 * 868.二进制间距
 */
public class Solution868 {

    public static int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int pre = 0;
        int res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '1'){
                res = Math.max(res,i - pre);
                pre = i;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(binaryGap(22));
    }
}
