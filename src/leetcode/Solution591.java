package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 591. 标签验证器
 */
public class Solution591 {

    public boolean isValid(String code) {

        int n = code.length();
        Deque<String> tags = new ArrayDeque<>();
        int index = 0;

        while(index < n){
            /**整体当前字符分为是否为'<'两种情况**/
            if(code.charAt(index) == '<'){
                if(index == n - 1){//'<'在闭合标签之外
                    return false;
                }
                if(code.charAt(index + 1) == '/'){//遇到了一个可能的endTag
                    int j = code.indexOf('>',index);
                    if(j < 0){
                        return false;//没有匹配的'>'
                    }
                    String tagName = code.substring(index + 2,j);
                    if(tags.isEmpty() || !tags.peek().equals(tagName)){
                        return false; //没有匹配的startTag
                    }
                    tags.pop();//匹配后清空栈顶的startTag
                    index = j + 1;
                    if(tags.isEmpty() && index != n){//说明在闭合标签外还有字符
                        return false;
                    }
                }else if(code.charAt(index + 1) == '!'){//遇到了一个可能的cdata
                    if(tags.isEmpty()){
                        return false;//说明在闭合标签之外
                    }
                    if(index + 9 > n){
                        return false;
                    }
                    String cdata = code.substring(index + 2,index + 9);
                    if (!"[CDATA[".equals(cdata)) {
                        return false;
                    }
                    int j = code.indexOf("]]>", index);
                    if (j < 0) {
                        return false;
                    }
                    index = j + 1;
                }else {
                    int j = code.indexOf('>', index);
                    if (j < 0) {//说明没有匹配的'>'
                        return false;
                    }
                    String tagName = code.substring(index + 1, j);
                    /**tagName的准则**/
                    if (tagName.length() < 1 || tagName.length() > 9) {//1 <= 长度 <= 9
                        return false;
                    }
                    for (int k = 0; k < tagName.length(); ++k) {//全部为大写
                        if (!Character.isUpperCase(tagName.charAt(k))) {
                            return false;
                        }
                    }
                    tags.push(tagName);
                    index = j + 1;
                }
            }else{
                /**如果当前字符不是'<'并且栈空，说明当前字符在闭合标签之外，返回false**/
                if(tags.isEmpty()){
                    return false;
                }
                ++index;
            }
        }
        return tags.isEmpty();
    }
}
