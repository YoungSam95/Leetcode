package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 */
public class Solution929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email : emails){
            String local = email.substring(0,email.indexOf('@')).split("\\+")[0];
            local = local.replace(".","");
            set.add(local + email.substring(email.indexOf('@')));
        }
        return set.size();
    }
}
