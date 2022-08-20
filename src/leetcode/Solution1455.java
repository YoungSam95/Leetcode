package leetcode;

/**
 * 1455. 检查单词是否为句中其他单词的前缀
 */
public class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int res = -1;
        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++){
            if(words[i].indexOf(searchWord) == 0){
                return i + 1;
            }
        }
        return res;
    }
}
