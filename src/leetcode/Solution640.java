package leetcode;

/**
 * 640. 求解方程
 */
public class Solution640 {
    public String solveEquation(String equation) {
        String[] s = equation.split("=");
        int[] left = findFactor(s[0]);
        int[] right = findFactor(s[1]);
        if(left[0] == right[0]){
            return left[1] == right[1] ? "Infinite solutions" : "No solution";
        }
        if((right[1] - left[1]) % (left[0] - right[0]) != 0){
            return "No solution";
        }
        return "x=" + (right[1] - left[1]) / (left[0] - right[0]);
    }

    public int[] findFactor(String s) {
        int[] res = new int[2];
        char[] c = s.toCharArray();
        int sign = 1, sum = 0, n = s.length();
        for(int i = 0; i < n; i++){
            if(Character.isDigit(c[i])){
                while(i < n && Character.isDigit(c[i])){
                    sum = sum * 10 + c[i] - '0';
                    i++;
                }
                if(i < n && c[i] == 'x'){
                    res[0] += sign * sum;
                }else{
                    res[1] += sign * sum;
                    i--;
                }
                sum = 0;
            }else if(c[i] == '-'){
                sign = -1;
            }else if(c[i] == '+'){
                sign = 1;
            }else{
                res[0] += sign;
            }
        }
        return res;
    }
    public static void main(String[] args){
        String e = "3x=33+22+11";
        Solution640 s = new Solution640();
        System.out.println(s.solveEquation(e));
    }
}
