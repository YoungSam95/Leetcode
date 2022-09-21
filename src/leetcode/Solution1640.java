package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1640. 能否连接形成数组
 */
public class Solution1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,int[]> map = new HashMap<>();
        for(int[] piece : pieces){
            map.put(piece[0],piece);
        }
        for(int i = 0; i < arr.length;){
            if(!map.containsKey(arr[i])) return false;
            int[] temp = map.get(arr[i]);
            for(int j = 0; j < temp.length; j++){
                if(temp[j] != arr[i++]) return false;
            }
        }
        return true;
    }
    public boolean canFormArray2(int[] arr, int[][] pieces) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < pieces.length; i++){
            map.put(pieces[i][0],i);
        }
        for(int i = 0; i < arr.length;){
            if(!map.containsKey(arr[i])) return false;
            int index = map.get(arr[i]);
            for(int j = 0; j < pieces[index].length; j++){
                if(arr[i++] != pieces[index][j]) return false;
            }
        }
        return true;
    }
}
