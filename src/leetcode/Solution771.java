package leetcode;

/**
 * 771. 宝石与石头
 */
public class Solution771 {
    public int numJewelsInStones(String jewels, String stones) {
        int res = 0;
        for(Character c : stones.toCharArray()) {
            if(jewels.contains(c + "")) {res++;}
        }
        return res;
    }
}
