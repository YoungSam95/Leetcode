package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2342. 数位和相等数对的最大和
 */
public class Solution2342 {
    public int maximumSum(int[] nums) {
        Arrays.sort(nums);
        int max1=-1;
        Map<Integer,Integer> map=new HashMap();
        for(int i=0;i<nums.length;i++){
            int val=get(nums[i]);
            if(!map.containsKey(val)){
                map.put(val,nums[i]);
            }else{
                max1=Math.max(map.get(val)+nums[i],max1);
                map.put(val,nums[i]);
            }
        }
        return max1;
    }

    public int get(int num){
        int s=0;
        while(num>0){
            s=s+num%10;
            num=num/10;
        }
        return s;
    }
}
