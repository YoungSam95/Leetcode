package leetcode;

/**
 * 824. 山羊拉丁文
 */
public class Solution824 {

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < words.length; i++){
            if(words[i].startsWith("a") || words[i].startsWith("e") || words[i].startsWith("i") || words[i].startsWith("o") || words[i].startsWith("u") ||
                    words[i].startsWith("A") || words[i].startsWith("E") || words[i].startsWith("I") || words[i].startsWith("O") || words[i].startsWith("U")){
                words[i] = words[i] + "ma";
            }else{
                words[i] = words[i].substring(1,words[i].length()) + words[i].charAt(0) + "ma";
            }
            for(int j = 0; j < i + 1; j++){
                words[i] = words[i] + "a";
            }
            res.append(words[i]).append(" ");
        }
        return res.toString().trim();
    }
}
