package huawei;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer,Integer> map = new TreeMap<>();
        int next = sc.nextInt();
        for (int i = 0; i < next; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            map.put(key,map.getOrDefault(key,0) + value);
        }
        for(Integer i : map.keySet()){
            System.out.print(i + " " + map.get(i) + "\n");
        }
    }
}
