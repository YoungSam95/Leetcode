package huawei;

import java.util.*;

public class HJ89 {
    public static Map<String,Integer> map = new HashMap<String,Integer>(){
        {
            put("A", 1);
            put("2", 2);
            put("3", 3);
            put("4", 4);
            put("5", 5);
            put("6", 6);
            put("7", 7);
            put("8", 8);
            put("9", 9);
            put("10",10);
            put("J", 11);
            put("Q", 12);
            put("K", 13);
        }
    };
    public static String[] num;
    public static int[] visited;
    public static List<List<String>> res;
    public static List<String> temp;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String poker = sc.nextLine();
            if(poker.contains("joker") || poker.contains("JOKER")){
                System.out.println("ERROR");
            }else{
                num = new String[4];
                visited = new int[4];
                Arrays.fill(visited,0);
                res = new ArrayList<>();
                temp = new ArrayList<>();
                for(int i = 0; i < 4; i++){
                    num[i] = poker.split(" ")[i];
                }
                for(int i = 0; i < 4; i++){
                    visited[i] = 1;
                    temp.add(num[i]);
                    dfs(1,map.get(num[i]));
                    temp.remove(temp.size()-1);
                    visited[i] = 0;
                }
                if(res.size() > 0 ) {
                    for (String s : res.get(0)) {
                        System.out.print(s);
                    }
                    System.out.println();
                }else{
                    System.out.println("NONE");
                }
            }
        }
    }

    public static void dfs(int count,int sum) {
        if(sum == 24 && count == 4){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < 4; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                temp.add("+");
                temp.add(num[i]);
                dfs(count+1,sum+map.get(num[i]));
                temp.remove(temp.size()-1);
                temp.remove(temp.size()-1);
                temp.add("-");
                temp.add(num[i]);
                dfs(count+1,sum-map.get(num[i]));
                temp.remove(temp.size()-1);
                temp.remove(temp.size()-1);
                temp.add("*");
                temp.add(num[i]);
                dfs(count+1,sum*map.get(num[i]));
                temp.remove(temp.size()-1);
                temp.remove(temp.size()-1);
                temp.add("/");
                temp.add(num[i]);
                dfs(count+1,sum/map.get(num[i]));
                temp.remove(temp.size()-1);
                temp.remove(temp.size()-1);
                visited[i] = 0;
            }
        }
    }
}
