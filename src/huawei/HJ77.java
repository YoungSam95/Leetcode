package huawei;

import java.util.*;

public class HJ77 {

    public static List<List<Integer>> res;
    public static Stack<Integer> stack;
    public static int[] arr;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            stack = new Stack<>();
            train(temp,0,0);
            StringBuilder sb = new StringBuilder();
            List<String> result=new ArrayList<>();
            for(List<Integer> list :res){
                sb=new StringBuilder();
                for(int i=0;i< list.size();i++){
                    sb.append(list.get(i));
                    if( i != list.size()-1){//不是最后一个,加空格
                        sb.append(" ");
                    }
                }
                result.add(sb.toString());
            }
            Collections.sort(result);
            for(String s:result){
                System.out.println(s);
            }
        }
    }

    //numOfOut表示出站的索引 numOfIn表示近战的索引
    private static void train(List<Integer> temp,int numOfOut, int numOfIn) {
        //base case:全部进站后并且都出来了 加入结果集
        if(numOfOut == n && numOfIn==n){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        //选择进站(火车列表里还有车的情况):列表不为空，就可以选择。选择之后递归，之后再撤销选择
        if(numOfIn != n){
            stack.push(arr[numOfIn]);
            train(temp,numOfOut,numOfIn+1);
            stack.pop();
        }

        //选择出战(车站即栈不为空的时候)
        if(!stack.isEmpty()){
            int x=stack.pop();
            temp.add(x);
            train(temp,numOfOut+1,numOfIn);
            temp.remove(temp.size()-1);//再去除最后一个
            stack.push(x);//再压进去
        }
    }
}
