package leetcode;

/**
 * 565. 数组嵌套
 */
public class Solution565 {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            int count = 0, index = i;
            while(nums[index] != -1){
                count++;
                int temp = index;
                index = nums[index];
                nums[temp] = -1;
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums = {5,4,0,3,1,6,2};
        Solution565 s = new Solution565();
        System.out.println(s.arrayNesting(nums));
    }
}
