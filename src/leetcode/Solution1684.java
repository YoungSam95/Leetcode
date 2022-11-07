package leetcode;

/**
 * 1684. 统计一致字符串的数目
 */
public class Solution1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int res = 0;
        for(String word : words){
            boolean flag = true;
            for(int i = 0; i < word.length(); i++){
                if(!allowed.contains(word.charAt(i) + "")){
                    flag = false;
                    break;
                }
            }
            if(flag) res++;
        }
        return res;
    }
    public int countConsistentStrings1(String allowed, String[] words) {
        int mask = 0;
        for (int i = 0; i < allowed.length(); i++) {
            char c = allowed.charAt(i);
            mask |= 1 << (c - 'a');
        }
        int res = 0;
        for (String word : words) {
            int mask1 = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                mask1 |= 1 << (c - 'a');
            }
            if ((mask1 | mask) == mask) {
                res++;
            }
        }
        return res;
    }
}
