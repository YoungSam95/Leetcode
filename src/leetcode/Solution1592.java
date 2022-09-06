package leetcode;

/**
 * 1592. 重新排列单词间的空格
 */
public class Solution1592 {
    public String reorderSpaces(String text) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.trim().split("\\s+");
        int count = 0;
        for(String word : words){
            count += word.length();
        }
        count = text.length() - count;
        if(words.length == 1){
            sb.append(words[0]);
            for(int i = 0; i < count; i++){
                sb.append(" ");
            }
            return sb.toString();
        }
        int avg = count / (words.length -1);
        for(int i = 0; i < words.length; i++){
            if(i > 0) {
                for (int j = 0; j < avg; j++) {
                    sb.append(" ");
                    count--;
                }
            }
            sb.append(words[i]);
        }
        for(int i = 0; i < count; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
