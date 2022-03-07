package leetcode;

public class Solution509 {

    public int fib(int n) {
        int[] memo = new int[n+1];
        return fib(memo,n);
    }
    public int fib(int[] memo,int n){
        if(n ==0 || n==1){
            return n;
        }
        if(memo[n] != 0) return memo[n];
        memo[n] = fib(memo,n-1)+fib(memo,n-2);
        return memo[n];
    }
}
