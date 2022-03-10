package huawei;

import java.util.Scanner;
import java.util.Stack;

public class HJ70 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[][] arr = new int[num][2];
        for(int i = 0; i < num; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        char[] chars = sc.next().toCharArray();
        int n = arr.length -1;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char one = chars[i];
            if (one == ')') {
                stack.push(-1);
            } else if (one == '(') {
                // 前一个矩阵
                int n1 = stack.pop();
                // 后一个矩阵
                int n2 = stack.pop();
                sum += arr[n1][0] * arr[n2][0] * arr[n2][1];
                // 新矩阵
                arr[n1][1] = arr[n2][1];
                // 去掉一个右括号
                stack.pop();
                // 将新矩阵压入栈中
                stack.push(n1);
            } else {
                // 压入第n个矩阵
                stack.push(n);
                n--;
            }
        }
        System.out.println(sum);
    }
}
