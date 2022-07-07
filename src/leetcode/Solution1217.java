package leetcode;

/**
 * 1217. 玩筹码
 * 思路：移动偶数格不需要消耗，移动奇数格需要消耗1，偶数可以通过移动一次变成奇数，奇数可以通过移动一次变成偶数。
 *      所以题目可以看成全部移动到奇数还是偶数的次数最少。
 *      如果要移动到奇数，则所有偶数移动一次变为奇数消耗1，然后每次移动偶数格不消耗；如果要移动到偶数，则所有奇数移动一次变为偶数消耗1，然后每次移动偶数格不消耗。
 *      所以最后的结果就是看偶数和奇数哪个数量最少。
 */
public class Solution1217 {
    public int minCostToMoveChips(int[] position) {
        int countOfEven = 0, countOfOdd = 0;
        for(int p : position){
            if(p % 2 == 0){
                countOfEven++;
            }else{
                countOfOdd++;
            }
        }
        return Math.min(countOfEven,countOfOdd);
    }
}
