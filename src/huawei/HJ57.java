package huawei;

import java.util.Scanner;
import java.util.Stack;

public class HJ57 {

    public static void  main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String n = sc.nextLine();
            String m = sc.nextLine();
            int i = n.length()-1;
            int j = m.length()-1;
            int carry = 0;
            Stack<Integer> stack = new Stack<>();
            while( i>=0 || j>=0){
                char c1 = '0';
                char c2 = '0';
                int result = 0;
                if(i >= 0){
                    c1 = n.charAt(i);
                }
                if(j >= 0){
                    c2 = m.charAt(j);
                }
                result = (c1 - 48) + (c2 - 48) + carry;
                if(result > 9){
                    result = result % 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                stack.push(result);
                i--;
                j--;
            }
            if(carry == 1){
                stack.push(1);
            }
            while(!stack.isEmpty()){
                System.out.print(stack.pop());
            }
            System.out.println();
        }

    }
}
