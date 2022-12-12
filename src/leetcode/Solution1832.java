package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1832. 判断句子是否为全字母句
 */
public class Solution1832 {
    public boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for(char c : sentence.toCharArray()){
            set.add(c);
        }
        return set.size() == 26;
    }
    public boolean checkIfPangram2(String sentence) {
        int state = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            state |= 1 << (c - 'a');
        }
        return state == (1 << 26) - 1;
    }
}
