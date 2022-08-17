package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1224. 最大相等频率
 * 思路：
 *      以nums[i] 结尾的数组前缀符合要求的充要条件为满足以下三个条件之一：
 *          最大出现次数maxFreq=1：那么所有数的出现次数都是一次，随意删除一个数既可符合要求。
 *          所有数的出现次数都是maxFreq或maxFreq−1，并且最大出现次数的数只有一个：删除一个最大出现次数的数，那么所有数的出现次数都是maxFreq−1。
 *          除开一个数，其他所有数的出现次数都是maxFreq，并且该数的出现次数为1：直接删除出现次数为 1 的数，那么所有数的出现次数都是maxFreq。
 */
public class Solution1224 {
    public int maxEqualFreq(int[] nums) {

        Map<Integer,Integer> count = new HashMap<>();//记录每个num出现的次数
        Map<Integer,Integer> freq = new HashMap<>();//记录出现次数为f的数的个数
        int res = 0, maxFreq = 0;//maxFreq记录最大出现次数

        for(int i = 0; i < nums.length; i++){

            //如果这个数之前出现过，则这个数之前出现的次数对应的数的个数要减去这个数（即 -1）
            if(count.getOrDefault(nums[i],0) > 0 ){
                freq.put(count.get(nums[i]), freq.get(count.get(nums[i])) - 1);
            }
            //如果这个数之前没出现过
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);//加入count
            maxFreq = Math.max(maxFreq, count.get(nums[i]));//更新最大出现次数
            freq.put(count.get(nums[i]), freq.getOrDefault(count.get(nums[i]), 0) + 1);//给这个数出现次数对应的数的个数加上这个数（即 +1）
            boolean flag = maxFreq == 1 || //最大出现次数maxFreq=1：那么所有数的出现次数都是一次，随意删除一个数既可符合要求。
                    freq.get(maxFreq) * maxFreq + freq.get(maxFreq - 1) * (maxFreq - 1) == i + 1 && freq.get(maxFreq) == 1 || //所有数的出现次数都是maxFreq或maxFreq−1，并且最大出现次数的数只有一个：删除一个最大出现次数的数，那么所有数的出现次数都是maxFreq−1。
                    freq.get(maxFreq) * maxFreq + 1 == i + 1 && freq.get(1) == 1; //除开一个数，其他所有数的出现次数都是maxFreq，并且该数的出现次数为1：直接删除出现次数为 1 的数，那么所有数的出现次数都是maxFreq。
            if (flag) {
                res = Math.max(res, i + 1);
            }
        }
        return res;
    }
}
