package huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HJ93 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //根据输入计算sum3，sum5和所有数总和sum，同时把不是5和3倍数的剩余数放入集合
            List<Integer> list = new ArrayList<>();
            int n = sc.nextInt();
            int sum5=0, sum3=0, sum = 0;
            for (int i = 0; i < n; i++){
                int cur = sc.nextInt();//输入
                if (cur % 5 == 0){//5倍数和
                    sum5 += cur;
                }else if (cur % 3 == 0){//3倍数和
                    sum3 += cur;
                }else{//剩余加入集合
                    list.add(cur);
                }
                sum += cur;//总和
            }

            //特例，总和不是2的倍数，不可分2份和相等的数字
            if(sum%2!=0) System.out.println("false");
            else{//否则，在剩余数中找目标数字
                int target = sum/2 - sum3;//也可以是sum/2-sum5
                System.out.println(helper(list, target, 0));
            }
        }
    }

    private static boolean helper(List<Integer> list, int target, int start){
        if (start == list.size()) return target == 0;//终止条件

        //选择start位置，递归找新目标数target-list.get(start)， 或者不选择start位置，在后面位置找target
        return helper(list, target-list.get(start), start+1) || helper(list, target, start+1);
    }
}
