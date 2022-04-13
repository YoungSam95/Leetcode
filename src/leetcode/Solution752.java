package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 */
public class Solution752 {
    public int openLock(String[] deadends, String target) {
        //BFS
        Set<String> dead = new HashSet<>();
        for(String str : deadends) dead.add(str);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(dead.contains(cur)) continue;
                if(cur.equals(target)) return step;
                for(int j = 0; j < 4; j++){
                    String plus = plusOne(cur,j);
                    if(!visited.contains(plus)){
                        q.offer(plus);
                        visited.add(plus);
                    }
                    String minus = minusOne(cur,j);
                    if(!visited.contains(minus)){
                        q.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if(ch[j] == '9'){
            ch[j] = '0';
        }else{
            ch[j] += 1;
        }
        return new String(ch);
    }
    public String minusOne(String cur, int j) {
        char[] ch = cur.toCharArray();
        if(ch[j] == '0'){
            ch[j] = '9';
        }else{
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
