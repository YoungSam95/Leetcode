package leetcode;

/**
 * 875. 爱吃香蕉的珂珂
 */
public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000001;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(eat(piles,mid) <= h){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    public int eat(int[] piles, int mid) {
        int hour = 0;
        for(int pile : piles){
            hour += pile / mid;
            if(pile % mid != 0){
                hour++;
            }
        }
        return hour;
    }
}
