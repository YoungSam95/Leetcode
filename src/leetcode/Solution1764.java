package leetcode;

/**
 * 1764. 通过连接另一个数组的子数组得到一个数组
 */
public class Solution1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int index = 0;
        for(int[] group : groups) {
            boolean has = false;
            for(; index <= nums.length - group.length; index++) {
                boolean flag = true;
                for(int j = 0; j < group.length; j++) {
                    if(nums[index + j] != group[j]){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    has = true;
                    index += group.length;
                    break;
                }
            }
            if(!has){
                return false;
            }
        }
        return true;
    }
}
