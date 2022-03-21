import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<int[]> res = new ArrayList<>();
        String str = sc.nextLine();
        int index = 0;
        while(index < str.length()){
            if(str.charAt(index) == '('){
                int start = index + 1;
                while(str.charAt(index) != ')'){
                    index +=1;
                }
                String x = str.substring(start,index).split(",")[0];
                String y = str.substring(start,index).split(",")[1];
                if(!x.startsWith("0") && Integer.parseInt(x)>0 && Integer.parseInt(x)<1000 &&
                        !y.startsWith("0") && Integer.parseInt(y)>0 && Integer.parseInt(y)<1000){
                    res.add(new int[]{Integer.parseInt(x),Integer.parseInt(y)});
                }
            }
            index++;
        }
        if(res.size() == 0){
            System.out.println("(0,0)");
        }else{
            int max = -1;
            int maxIndex = -1;
            for(int i = 0; i < res.size();i++){
                int x = res.get(i)[0];
                int y = res.get(i)[1];
                if(x*x+y*y > max ){
                    max = x*x+y*y;
                    maxIndex = i;
                }
            }
            int x = res.get(maxIndex)[0];
            int y = res.get(maxIndex)[1];
            System.out.println("(" + x + "," + y + ")");
        }
    }
}
