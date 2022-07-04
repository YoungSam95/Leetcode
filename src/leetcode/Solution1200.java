package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1200. 最小绝对差
 */
public class Solution1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length, min = Integer.MAX_VALUE;
        for(int i = 0; i < n - 1; i++){
            int temp = arr[i + 1] - arr[i];
            if(temp < min){
                min = temp;
                ans.clear();
            }
            if(temp == min){
                List<Integer> curr = new ArrayList<>();
                curr.add(arr[i]);
                curr.add(arr[i + 1]);
                ans.add(curr);
            }
        }
        return ans;
    }
}
