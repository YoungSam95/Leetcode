import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution3 {

    public static int length;
    public static List<String> res;
    public static int n;
    public static StringBuilder sb;
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            n = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            length = str.length();
            res = new ArrayList<>();
            for(int i = 0; i < n; i++){
                sb = new StringBuilder();
                char ch = (char)(97+i);
                sb.append(ch);
                dfs(sb,1);
            }
            if(res.size() == 0){
                System.out.println("NO");
            }else {
                int index = -1;
                for (int i = 0; i < res.size(); i++) {
                    if (res.get(i).equals(str)) {
                        index = i;
                    }
                }
                System.out.println(res.get(index + 1));
            }
        }
    }

    public static void dfs(StringBuilder sb, int count) {
        if(count == length){
            if(check(sb)) {
                res.add(sb.toString());
            }
            return;
        }
        for(int i = 0; i < n;i++){
            char ch = (char)(97+i);
            sb.append(ch);
            dfs(sb,count + 1);
            sb.delete(sb.length()-1,sb.length());
        }

    }

    public static boolean check(StringBuilder sb) {

        String str = sb.toString();
        for(int i = 0; i < str.length()-1;i++ ){
            if(str.charAt(i)==str.charAt(i+1)) return false;
            if(i>0 && str.charAt(i-1)==str.charAt(i+1)) return false;
        }
        return true;
    }
}
