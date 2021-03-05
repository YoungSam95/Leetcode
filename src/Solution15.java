/**
 * 15. 三数之和
 *     给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 请你找出所有和为 0 且不重复的三元组。
       注意：答案中不可以包含重复的三元组。
    解题思路：
             将数组排序
             固定一位数，然后通过两个指针对撞，寻找总和为 0 的三个数
 */
import java.util.*;

public class Solution15 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.emptyList();
        }

        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);

        int zCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zCount++;
            }
        }

        for (int i = 0; i < nums.length && nums[i] < 0; i++) {
            int first = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int t = nums[j] + nums[k] + first;
                if (t == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    res.add(list);
                    j++;
                    k--;
                } else if (t > 0) {
                    k--;
                } else {
                    j++;
                }
            }

        }

        if (zCount >= 3) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add(list);
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args){

    }
}
