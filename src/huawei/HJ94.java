package huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String[] strs = sc.nextLine().split(" ");
            int m = sc.nextInt();
            sc.nextLine();
            String[] votes = sc.nextLine().split(" ");
            int Invalid = 0;
            Map<String,Integer> map = new HashMap<>();
            for(String str : strs){
                map.put(str,0);
            }
            for(String str : votes){
                if(map.containsKey(str)){
                    map.put(str,map.getOrDefault(str,0)+1);
                }else{
                    Invalid++;
                }
            }
            for(int i = 0; i < n; i++){
                System.out.println(strs[i] + " " + ":" + " " + map.get(strs[i]));
            }
            System.out.println("Invalid" + " " + ":" + " " + Invalid);
        }
    }
}
