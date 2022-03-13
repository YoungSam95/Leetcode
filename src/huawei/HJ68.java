package huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HJ68 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,String> map = new HashMap<>();
        while(sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            int flag = Integer.valueOf(sc.nextLine());
            int[][] score = new int[n][2];
            for(int i=0;i<n;i++){
                String[] nameAndScore = sc.nextLine().split("\\s+");
                score[i][0] = i;
                score[i][1] = Integer.parseInt(nameAndScore[1]);
                map.put(i,nameAndScore[0]);
            }
            Arrays.sort(score,(o1, o2) ->{
                if(flag==0){
                    return o2[1] - o1[1];//按第二列降序排列,如果相等的话，返回0，顺序不变
                }else{
                    return o1[1] - o2[1];//按第二列升序
                }
            });
            for(int i=0;i<n;i++){
                System.out.println(map.get(score[i][0]) + " " + score[i][1]);
            }
        }
    }
}
