package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 */
public class Solution1461 {
    public boolean hasAllCodes(String s, int k) {
        if (s.length() < (1 << k) + k - 1) {
            return false;
        }

        Set<String> exists = new HashSet<String>();
        for (int i = 0; i + k <= s.length(); ++i) {
            exists.add(s.substring(i, i + k));
        }
        return exists.size() == (1 << k);
    }
}
