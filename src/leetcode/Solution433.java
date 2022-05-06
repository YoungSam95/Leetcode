package leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 433. 最小基因变化
 */

public class Solution433 {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> banks = new HashSet<>();
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
        return -1;
    }
}
