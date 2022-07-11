package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 676. 实现一个魔法字典
 */
public class Solution676 {
    class MagicDictionary {
        private String[] words;
        public MagicDictionary() {

        }

        public void buildDict(String[] dictionary) {
            words = dictionary;
        }

        public boolean search(String searchWord) {
            for(String word : words){
                if(word.length() == searchWord.length()){
                    int temp = 0;
                    for(int i = 0; i < word.length(); i++){
                        if(word.charAt(i) != searchWord.charAt(i)) temp++;
                        if(temp > 1) break;
                    }
                    if(temp == 1) return true;
                }
            }
            return false;
        }
    }
}
