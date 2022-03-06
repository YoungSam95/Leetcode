package huawei;

import java.util.Scanner;

public class HJ51 {

    public class ListNode{
        public int val;
        public ListNode next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++){
                nums[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            if(k<=n && k >=1){
                System.out.println(nums[n-k]);
            }else{
                System.out.println(0);
            }

        }
    }
}
