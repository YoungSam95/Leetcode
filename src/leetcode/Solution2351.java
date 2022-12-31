package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2351. 第一个出现两次的字母
 */
public class Solution2351 {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for(Character c : s.toCharArray()){
            if(set.add(c) == false){
                return c;
            }
        }
        return 'a';
    }
}
