package leetcode;

import java.util.*;

/**
 * 2785. 将字符串中的元音字母排序
 */
public class Solution2785 {
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList(
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U'
    ));

    public String sortVowels(String s) {
        List<Character> tmp = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (vowels.contains(ch)) {
                tmp.add(ch);
            }
        }

        Collections.sort(tmp);

        char[] arr = s.toCharArray();
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (vowels.contains(arr[i])) {
                arr[i] = tmp.get(idx++);
            }
        }

        return new String(arr);
    }
}
