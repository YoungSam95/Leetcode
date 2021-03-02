/**
 * 43. 字符串相乘
 *   给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 解题思路：
 *   1.使用数组代替字符串存储结果，则可以减少对字符串的操作。
 *   2.创建n1+n2长度的数组ans存储乘积，num[i]*num[j]的结果位于ans[i+j+1]中，如果ans[i+j+1]>=10,则将进位部分加入ans[i+j]中。
 *   3最后，将数组ans 转成字符串，如果最高位是 0则舍弃最高位。
 **/
public class Solution43 {

    public static  String multiply(String num1, String num2) {

        if(num1.length() == 0 || num2.length() == 0) return "0";
        if(num1.equals("0") || num2.equals("0")) return "0";
        if(num1.equals("1")) return num2;
        if(num2.equals("1")) return num1;

        int n1 = num1.length();
        int n2 = num2.length();
        int[] ans = new int[n1+n2];

        for(int i = n1-1;i >= 0;i--){
            for(int j = n2-1;j >= 0;j--){
                ans[i+j+1] +=(num1.charAt(i) - '0')*(num2.charAt(j) - '0');
            }
        }

        for(int i = n1+n2-1;i>0;i--){
            ans[i-1] += ans[i]/10;
            ans[i] = ans[i]%10;
        }

        int index = ans[0] == 0 ? 1 : 0;
        StringBuffer ansArr = new StringBuffer();
        //String ansArr = new String();
        while(index < n1 + n2){
            ansArr.append(ans[index]);
            //ansArr = ansArr + ans[index];
            index++;
        }

        return ansArr.toString();
    }

    public static void main(String[] args) {

        String num1 = "12";
        String num2 = "12";
        System.out.println(multiply(num1,num2));
    }
}
