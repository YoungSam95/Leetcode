package leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 433. 最小基因变化
 */

public class Solution433 {

    public static int minMutation(String start, String end, String[] bank) {
        /*Set<String> banks = new HashSet<>();
        Set<String> visited = new HashSet<>();
        char[] keys = {'A','C','G','T'};
        for(String str : bank){
            banks.add(str);
        }
        if(start.equals(end)) return 0;
        if(!banks.contains(end)) return -1;
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        visited.add(start);
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                for(int j = 0; j < 8; j++){
                    for(int k = 0; k < 4; k++){
                        if(curr.charAt(j) != keys[k]){
                            StringBuffer sb = new StringBuffer(curr);
                            sb.setCharAt(j,keys[k]);
                            String changed = sb.toString();
                            if(!visited.contains(changed) && banks.contains(changed)){
                                if(changed.equals(end)) return step;
                                queue.offer(changed);
                                visited.add(changed);
                            }
                        }
                    }
                }
            }
            step++;
        }
        return -1;*/
        /**通过对两个字符串不同字符个数的判断，过滤掉多余的变化**/
        if(start.equals(end)) return 0;
        int step = 1;
        boolean[] visited = new boolean[bank.length];
        for(int i = 0; i < bank.length; i++){
            if(start.equals(bank[i])){
                visited[i] = true;
            }
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                for(int j = 0; j < bank.length; j++){
                    if(!visited[j] && check(curr,bank[j]) == 1){
                        if(end.equals(bank[j])) return step;
                        visited[j] = true;
                        queue.offer(bank[j]);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static int check(String curr, String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(curr.charAt(i) != s.charAt(i)) count++;
        }
        return count;
    }
    public static void main(String[] args){
        String start = "AACCGGTT";
        String end = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(minMutation(start,end,bank));
    }
}
