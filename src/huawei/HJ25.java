package huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class HJ25 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int numOfI = sc.nextInt();
            int[] I = new int[numOfI];
            for(int i = 0; i < numOfI; i++){
                I[i] = sc.nextInt();
            }
            int numOfR = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0; i < numOfR; i++){
                set.add(sc.nextInt());
            }
            numOfR = set.size();
            int[] R = new int[numOfR];
            for(int i = 0; i < numOfR; i++){
                R[i] = set.pollFirst();
            }
            StringBuilder res = new StringBuilder();
            int total = 0;
            for(int i = 0; i <numOfR; i++){
                int count = 0;
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < numOfI; j++){
                    if(String.valueOf(I[j]).contains(String.valueOf(R[i]))){
                        count++;
                        total += 2;
                        sb.append(j).append(" ").append(I[j]).append(" ");
                    }
                }
                if(count > 0){
                    total += 2;
                    res.append(R[i]).append(" ").append(count).append(" ").append(sb);
                }
            }

            String result = total + " " + res.substring(0,res.length()-1);
            System.out.println(result);
        }
    }
}
