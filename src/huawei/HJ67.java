package huawei;

import java.util.Scanner;

public class HJ67 {

    public static int[] num;
    public static int[] visited;
    public static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            num = new int[4];
            visited = new int[4];
            flag = false;
            for(int i = 0; i < 4; i++){
                num[i] = sc.nextInt();
            }
            for(int i = 0; i < num.length;i++){
                visited[i] = 1;
                if(dfs(num[i])){
                    flag = true;
                    break;
                }
                visited[i] = 0;
            }
            System.out.println(flag);
        }
    }

    private static boolean dfs(double nums) {
        for(int i = 0; i < num.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(dfs(nums + num[i]) ||
                   dfs(nums - num[i]) ||
                   dfs(nums * num[i]) ||
                   dfs(nums / num[i])){
                    return true;
                }
                visited[i] = 0;
            }
        }
        if(nums == 24) return true;
        return false;
    }
}

