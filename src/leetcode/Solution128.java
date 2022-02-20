package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 *      给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *      例如：
 *       输入：nums = [100,4,200,1,3,2]
 *       输出：4
 *       解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 解题思路：
 *        用 Set 保存所有数字
 *        遍历数组，查找当前数字之前、之后的数，并计算个数
 */
public class Solution128 {

    public static int longestConsecutive(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int pre, after, max = 0;
        /*for (int num : nums) {
            int temp = 1;
            set.remove(num);

            pre = num;
            after = num;

            while (set.contains(--pre)) {
                temp++;
                set.remove(pre);
            }

            while (set.contains(++after)) {
                temp++;
                set.remove(after);
            }

            max = Math.max(max, temp);
            if (max > nums.length / 2) {
                return max;
            }
        }*/

        for(int num : set){
            if(!set.contains(num - 1)){
                int tempMax = 1;
                int tempNum = num;
                while(set.contains(++tempNum)){
                    tempMax++;
                }
                max = Math.max(max,tempMax);
            }
        }

        return max;
    }

    public static void main(String[] args){

        int[] nums1 = {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums1));
        System.out.println(longestConsecutive(nums2));
    }
}
