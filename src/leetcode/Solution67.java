package leetcode;

/**
 * 67.二进制求和
 */
public class Solution67 {
    public static String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i>=0 || j>=0){
            int temp = 0;
            if(i>=0){
                temp += Integer.valueOf(a.substring(i,i+1));
                i--;
            }
            if(j>=0){
                temp +=Integer.valueOf(b.substring(j,j+1));
                j--;
            }
            temp += carry;
            if(temp > 1){
                sb.append(temp%2+"");
                carry = 1;
            }else{
                sb.append(temp+"");
                carry = 0;
            }
        }
        if(carry != 0) sb.append("1");
        return sb.reverse().toString();
    }
    public static void main(String[] args){
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a,b));
    }
}
