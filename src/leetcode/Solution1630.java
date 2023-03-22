package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1630. 等差子数组
 */
public class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < l.length; i++){
            int arr[]= Arrays.copyOfRange(nums,l[i],r[i]+1);
            Arrays.sort(arr);
            int d = arr[1]-arr[0];
            boolean ch = true;
            for(int j = 2; j <= r[i] - l[i]; j++){
                if(d != arr[j] - arr[j - 1]){
                    ch = false;
                    break;
                }
            }
            ans.add(ch);
        }
        return ans;
    }
}
